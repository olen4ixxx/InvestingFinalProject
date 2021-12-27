package io.olen4ixxx.investing.util;

import io.olen4ixxx.investing.entity.User;
import io.olen4ixxx.investing.entity.UserRole;
import io.olen4ixxx.investing.entity.UserStatus;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserSetter {
    public UserSetter() {
    }

    public static void setUser(User user, ResultSet resultSet) throws SQLException {
        user.setUserId(resultSet.getLong("userId"));
        user.setRole(UserRole.valueOf(resultSet.getString("role")));
        user.setFirstName(resultSet.getString("FirstName"));
        user.setLastName(resultSet.getString("LastName"));
        user.setStatus(UserStatus.valueOf(resultSet.getString("status")));
        user.setPhoneNumber(resultSet.getLong("phoneNumber"));
        user.setLogin(resultSet.getString("login"));
        user.setPassword(resultSet.getString("password"));
        user.setImageReference(resultSet.getString("imageReference"));
    }

    public static void setStatement(PreparedStatement preparedStatement, User user) throws SQLException {
        preparedStatement.setString(1, user.getRole().toString());
        preparedStatement.setString(2, user.getFirstName());
        preparedStatement.setString(3, user.getLastName());
        preparedStatement.setString(4, user.getStatus().toString());
        preparedStatement.setLong(5, user.getPhoneNumber());
        preparedStatement.setString(6, user.getLogin());
        preparedStatement.setString(7, user.getPassword());
        preparedStatement.setString(8, user.getImageReference());
    }
}
