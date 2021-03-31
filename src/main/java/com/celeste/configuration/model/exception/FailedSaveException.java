package com.celeste.configuration.model.exception;

import org.jetbrains.annotations.NotNull;

public class FailedSaveException extends ConfigException {

    /**
     * @param error String
     */
    public FailedSaveException(@NotNull final String error) {
        super(error);
    }

    /**
     * @param cause Throwable
     */
    public FailedSaveException(@NotNull final Throwable cause) {
        super(cause);
    }

    /**
     * @param error String
     * @param cause Throwable
     */
    public FailedSaveException(@NotNull final String error, @NotNull final Throwable cause) {
        super(error, cause);
    }

}
