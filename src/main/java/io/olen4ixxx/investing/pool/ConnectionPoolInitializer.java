package io.olen4ixxx.investing.pool;

import io.olen4ixxx.investing.util.PropertiesInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

class ConnectionPoolInitializer {
    private static final Logger logger = LogManager.getLogger();
    private static String url;
    private static String username;
    private static String password;
    private static String driver;
    private static int poolSize;

    private ConnectionPoolInitializer() {
    }

    static void init() {
        // TODO: getConnections
        Properties properties = PropertiesInitializer.initProperties();
        url = (String) properties.get("db.url");
        username = (String) properties.get("db.username");
        password = (String) properties.get("db.password");
        driver = (String) properties.get("db.driver");
        poolSize = (int) properties.get("poolSize"); // TODO: 24.12.2021
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            logger.error("Driver registration failed", e);
        }
    }

    static ProxyConnection establishConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            logger.error("Connection get failed", e);
        }
        return new ProxyConnection(connection);
    }
}
