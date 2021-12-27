package io.olen4ixxx.investing.dao;

import io.olen4ixxx.investing.entity.Client;
import io.olen4ixxx.investing.exception.DaoException;

public interface ClientDao extends BaseDao<Long, Client> {
    Client findOrder(Client client) throws DaoException;
}
