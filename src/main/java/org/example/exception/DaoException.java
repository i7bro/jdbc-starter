package org.example.exception;

import java.util.concurrent.ThreadPoolExecutor;

public class DaoException extends RuntimeException {

    public DaoException(Throwable throwable) {
        super(throwable);
    }
}
