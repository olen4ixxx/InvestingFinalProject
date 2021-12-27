package io.olen4ixxx.investing.dao.impl;

import io.olen4ixxx.investing.dao.UserDao;
import io.olen4ixxx.investing.entity.User;
import io.olen4ixxx.investing.exception.DaoException;
import io.olen4ixxx.investing.pool.ConnectionPool;
import io.olen4ixxx.investing.util.UserSetter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private static final Logger logger = LogManager.getLogger();
    private static final String CREATE_QUERY = """
        INSERT INTO users(
        role, firstname, lastname, status, phoneNumber, login, password, imageReference) 
        VALUES(?, ?, ?, ?, ?, ?, ?, ?)""";
    private static final String FIND_ALL_QUERY = """
            SELECT role, firstname, lastname, status, phoneNumber, login, password, imageReference
            FROM users""";
    private static final String FIND_BY_ID_QUERY = FIND_ALL_QUERY.concat("WHERE id=?");
    private final ConnectionPool pool = ConnectionPool.getInstance();

    @Override
    public boolean create(User user) throws DaoException {
        return false;
    }

    @Override
    public List<User> findAll() throws DaoException {
        List<User> users = new ArrayList<>();
        Connection connection = pool.takeConnection();
        try (PreparedStatement statement = connection.prepareStatement(FIND_ALL_QUERY)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                UserSetter.setUser(user, resultSet);
                users.add(user);
            }
        } catch (SQLException e) {
            logger.error("findAll ERROR", e);
            throw new DaoException("findAll ERROR", e);
        }
        return users;
    }

    @Override
    public User findById(Long aLong) throws DaoException {
        return null;
    }

    @Override
    public User update(Long aLong, User user) throws DaoException {
        return null;
    }

    @Override
    public boolean delete(Long aLong) throws DaoException {
        return false;
    }

    @Override
    public User findUser(User user) throws DaoException {
        return null;
    }
}
