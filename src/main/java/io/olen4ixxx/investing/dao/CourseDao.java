package io.olen4ixxx.investing.dao;

import io.olen4ixxx.investing.entity.Course;
import io.olen4ixxx.investing.exception.DaoException;

public interface CourseDao extends BaseDao<Long, Course> {
    Course findOrder(Course course) throws DaoException;
}
