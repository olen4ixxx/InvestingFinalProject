package io.olen4ixxx.investing.dao.impl;

import io.olen4ixxx.investing.dao.CourseDao;
import io.olen4ixxx.investing.entity.Course;
import io.olen4ixxx.investing.exception.DaoException;

import java.util.List;

public class CourseDaoImpl implements CourseDao {
    @Override
    public boolean create(Course course) throws DaoException {
        return false;
    }

    @Override
    public List<Course> findAll() throws DaoException {
        return null;
    }

    @Override
    public Course findById(Long aLong) throws DaoException {
        return null;
    }

    @Override
    public Course update(Long aLong, Course course) throws DaoException {
        return null;
    }

    @Override
    public boolean delete(Long aLong) throws DaoException {
        return false;
    }

    @Override
    public Course findOrder(Course course) throws DaoException {
        return null;
    }
}
