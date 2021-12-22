package io.olen4ixxx.investing.exception;

public class DaoException extends Exception { // TODO: 21.12.2021
    public DaoException(String message) {
        super(message);
    }

    public DaoException(String message, Throwable cause) {
        super(message, cause);
    }

    public DaoException() {
    }

    public DaoException(Throwable cause) {
        super(cause);
    }
}
