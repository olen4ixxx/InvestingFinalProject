package io.olen4ixxx.investing.dao;

import io.olen4ixxx.investing.entity.Tutor;
import io.olen4ixxx.investing.exception.DaoException;

public interface TutorDao extends BaseDao<Long, Tutor> {
    Tutor findOrder(Tutor tutor) throws DaoException;
}
