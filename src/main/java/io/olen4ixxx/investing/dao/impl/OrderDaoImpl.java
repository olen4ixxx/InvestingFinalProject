package io.olen4ixxx.investing.dao.impl;

import io.olen4ixxx.investing.dao.OrderDao;
import io.olen4ixxx.investing.entity.Order;
import io.olen4ixxx.investing.exception.DaoException;

import java.util.List;

public class OrderDaoImpl implements OrderDao {
    @Override
    public boolean create(Order order) throws DaoException {
        return false;
    }

    @Override
    public List<Order> findAll() throws DaoException {
        return null;
    }

    @Override
    public Order findById(Long aLong) throws DaoException {
        return null;
    }

    @Override
    public Order update(Long aLong, Order order) throws DaoException {
        return null;
    }

    @Override
    public boolean delete(Long aLong) throws DaoException {
        return false;
    }

    @Override
    public Order findOrder(Order order) throws DaoException {
        return null;
    }
}
