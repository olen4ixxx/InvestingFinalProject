package io.olen4ixxx.investing.dao;

import io.olen4ixxx.investing.entity.InvestingEntity;
import io.olen4ixxx.investing.exception.DaoException;

import java.util.List;

public interface BaseDao<K, T extends InvestingEntity> {
    boolean create(T t) throws DaoException;
    List<T> findAll() throws DaoException;
    T findById(K k) throws DaoException;
    T update(K k, T t) throws DaoException;
    boolean delete (K k) throws DaoException;
}
