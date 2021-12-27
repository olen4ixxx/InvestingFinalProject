package io.olen4ixxx.investing.dao;

import io.olen4ixxx.investing.entity.Order;
import io.olen4ixxx.investing.exception.DaoException;

public interface OrderDao extends BaseDao<Long, Order> {
    Order findOrder(Order order) throws DaoException;
}
