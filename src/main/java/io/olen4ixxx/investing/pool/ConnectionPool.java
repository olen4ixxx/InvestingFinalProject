package io.olen4ixxx.investing.pool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.lang.module.Configuration;
import java.sql.*;
import java.util.Properties;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionPool {
    private static final Logger logger = LogManager.getLogger();
//    private static final String DB_URL;
//    private static final String DB_USERNAME;
//    private static final String DB_PASSWORD;

    private static ConnectionPool instance;
    private BlockingQueue<ProxyConnection> availableConnections;
    private BlockingQueue<ProxyConnection> usedConnections;
    private static final ReentrantLock lock = new ReentrantLock();
    private static final AtomicBoolean isCreated = new AtomicBoolean(false);



    private ConnectionPool() {
        // TODO: register driver
        init();
    }

    private void init() {
        // TODO: get connections from util class
//        Driver manager.getConnection in try and catch with log
//        if no connections or <2 => exceptionInInitializationError or RunTime and stop app
//        if <n from props getMoreConnections
        availableConnections = new LinkedBlockingQueue<>(7); // FIXME: constant
        usedConnections = new LinkedBlockingQueue<>();
        ConnectionPoolInitializer.init();
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
            //log
            Thread.currentThread().interrupt();
        }
        return connection;
    }

    public boolean releaseConnection(Connection connection) {
        //check getClass = proxyConnection, cast
        //control through timerTask time to time
        if (connection instanceof ProxyConnection proxyConnection) {
            usedConnections.remove(proxyConnection);
            try {
                availableConnections.put(proxyConnection);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return true; // TODO: 21.12.2021
    }

    public void closePool() { // FIXME: boolean?
        //fori -> take only from available -> closeActually
    }

    private void deregisterDrivers() {
        //lambda
    }
}
