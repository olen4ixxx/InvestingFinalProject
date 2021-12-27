package io.olen4ixxx.investing.dao.impl;

import io.olen4ixxx.investing.dao.CommentDao;
import io.olen4ixxx.investing.entity.Comment;
import io.olen4ixxx.investing.exception.DaoException;

import java.util.List;

public class CommentDaoImpl implements CommentDao {
    @Override
    public boolean create(Comment comment) throws DaoException {
        return false;
    }

    @Override
    public List<Comment> findAll() throws DaoException {
        return null;
    }

    @Override
    public Comment findById(Long aLong) throws DaoException {
        return null;
    }

    @Override
    public Comment update(Long aLong, Comment comment) throws DaoException {
        return null;
    }

    @Override
    public boolean delete(Long aLong) throws DaoException {
        return false;
    }

    @Override
    public Comment findOrder(Comment comment) throws DaoException {
        return null;
    }
}
