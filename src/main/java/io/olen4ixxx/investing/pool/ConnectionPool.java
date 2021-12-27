package io.olen4ixxx.investing.pool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionPool {
    private static final Logger logger = LogManager.getLogger();
    private static final int DEFAULT_POOL_CAPACITY = 7;
    private static final int ATTEMPTS_TO_FILL_POOL = 3;

    private static ConnectionPool instance;
    private BlockingQueue<ProxyConnection> availableConnections;
    private BlockingQueue<ProxyConnection> usedConnections;
    private static final ReentrantLock lock = new ReentrantLock();
    private static final AtomicBoolean isCreated = new AtomicBoolean(false);


    private ConnectionPool() {
        init();
    }

    private void init() {
        // TODO: get connections from util class
        availableConnections = new LinkedBlockingQueue<>(DEFAULT_POOL_CAPACITY); // FIXME: constant/properties
        int k = 0;
        while (availableConnections.size() < DEFAULT_POOL_CAPACITY || k < ATTEMPTS_TO_FILL_POOL) {
            for (int i = 0; i < DEFAULT_POOL_CAPACITY; i++) {
                try {
                    availableConnections.put(ConnectionPoolInitializer.establishConnection());
                } catch (InterruptedException e) {
                    logger.error("Connection put failed", e);
                }
            }
            k++;
        }
        if (availableConnections.size() < DEFAULT_POOL_CAPACITY) { // FIXME: always false?
            logger.fatal("Pool init failed");
            throw new RuntimeException("Pool init failed");
        }
//        if no connections or <2 => exceptionInInitializationError or RunTime and stop app
//        if <n from props getMoreConnections
        usedConnections = new LinkedBlockingQueue<>();
    }

    public static ConnectionPool getInstance() {
        if (!isCreated.get()) {
            try {
                lock.lock();
                if (instance == null) {
                    instance = new ConnectionPool();
                    isCreated.set(true);
                }
            } finally {
                lock.unlock();
            }
        }
        return instance;
    }

    public Connection takeConnection() {
        // TODO: 21.12.2021
        ProxyConnection connection = null;
        try {
            connection = availableConnections.take();
            usedConnections.put(connection);
        } catch (InterruptedException e) {
            logger.error("Connection take failed", e);
            Thread.currentThread().interrupt();
        }
        return connection;
    }

    public void releaseConnection(Connection connection) {
        //check getClass = proxyConnection, cast
        //control through timerTask time to time
        if (connection instanceof ProxyConnection proxyConnection) {
            usedConnections.remove(proxyConnection);
            try {
                availableConnections.put(proxyConnection);
            } catch (InterruptedException e) {
                logger.error("Connection release failed", e);
            }
        }
    }

    public void closePool() { // FIXME: boolean?
        for (int i = 0; i < availableConnections.size(); i++) {
            try {
                ProxyConnection connection = availableConnections.take();
                connection.closeActually();
            } catch (InterruptedException | SQLException e) {
                logger.error("Pool close failed", e);
            }
        }
    }

    private void deregisterDrivers() {
        DriverManager.getDrivers().asIterator().forEachRemaining(driver -> {
            try {
                DriverManager.deregisterDriver(driver);
            } catch (SQLException e) {
                logger.error("Driver deregistration failed", e);
            }
        });
    }
}
