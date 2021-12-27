package io.olen4ixxx.investing.dao.impl;

import io.olen4ixxx.investing.dao.ClientDao;
import io.olen4ixxx.investing.entity.Client;
import io.olen4ixxx.investing.exception.DaoException;

import java.util.List;

public class ClientDaoImpl implements ClientDao {
    @Override
    public boolean create(Client client) throws DaoException {
        return false;
    }

    @Override
    public List<Client> findAll() throws DaoException {
        return null;
    }

    @Override
    public Client findById(Long aLong) throws DaoException {
        return null;
    }

    @Override
    public Client update(Long aLong, Client client) throws DaoException {
        return null;
    }

    @Override
    public boolean delete(Long aLong) throws DaoException {
        return false;
    }

    @Override
    public Client findOrder(Client client) throws DaoException {
        return null;
    }
}
