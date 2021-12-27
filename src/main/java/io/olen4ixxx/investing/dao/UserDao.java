package io.olen4ixxx.investing.dao;

import io.olen4ixxx.investing.entity.User;
import io.olen4ixxx.investing.exception.DaoException;

public interface UserDao extends BaseDao<Long, User> {
    User findUser(User user) throws DaoException;
}
