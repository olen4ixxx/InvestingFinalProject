package io.olen4ixxx.investing.exception;

public class ServletException extends Exception { // TODO: 21.12.2021
    public ServletException(String message) {
        super(message);
    }

    public ServletException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServletException() {
    }

    public ServletException(Throwable cause) {
        super(cause);
    }
}
