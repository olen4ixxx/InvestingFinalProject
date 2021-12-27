package io.olen4ixxx.investing.dao.impl;

import io.olen4ixxx.investing.dao.TutorDao;
import io.olen4ixxx.investing.entity.Tutor;
import io.olen4ixxx.investing.exception.DaoException;

import java.util.List;

public class TutorDaoImpl implements TutorDao {
    @Override
    public boolean create(Tutor tutor) throws DaoException {
        return false;
    }

    @Override
    public List<Tutor> findAll() throws DaoException {
        return null;
    }

    @Override
    public Tutor findById(Long aLong) throws DaoException {
        return null;
    }

    @Override
    public Tutor update(Long aLong, Tutor tutor) throws DaoException {
        return null;
    }

    @Override
    public boolean delete(Long aLong) throws DaoException {
        return false;
    }

    @Override
    public Tutor findOrder(Tutor tutor) throws DaoException {
        return null;
    }
}
