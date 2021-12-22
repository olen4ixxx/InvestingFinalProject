package io.olen4ixxx.investing.exception;

public class PoolException extends Exception { // TODO: 21.12.2021
    public PoolException(String message) {
        super(message);
    }

    public PoolException(String message, Throwable cause) {
        super(message, cause);
    }

    public PoolException() {
    }

    public PoolException(Throwable cause) {
        super(cause);
    }
}
