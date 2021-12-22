package io.olen4ixxx.investing.pool;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

class ConnectionPoolInitializer {
    static void init() {
        // TODO: getConnections
        // get login etc. from props (some default cases)
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        if no connections or <2 => exceptionInInitializationError or RunTime and stop app
//        if <n from props getMoreConnections
        Properties properties = new Properties();
        ClassLoader classLoader = ConnectionPoolInitializer.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("application.properties");
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String url = (String) properties.get("db.url");
        String username = (String) properties.get("db.username");
        String password = (String) properties.get("db.password");
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users;");
            resultSet.next();
            System.out.println(resultSet.getString(4)); // FIXME: 22.12.2021 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
