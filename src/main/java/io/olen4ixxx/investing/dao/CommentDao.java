package io.olen4ixxx.investing.dao;

import io.olen4ixxx.investing.entity.Comment;
import io.olen4ixxx.investing.exception.DaoException;

public interface CommentDao extends BaseDao<Long, Comment> {
    Comment findOrder(Comment comment) throws DaoException;
}
