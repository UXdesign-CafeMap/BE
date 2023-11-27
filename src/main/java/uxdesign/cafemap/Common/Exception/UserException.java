package uxdesign.cafemap.Common.Exception;

import lombok.Getter;
import uxdesign.cafemap.Common.Response.status.ResponseStatus;

@Getter
public class UserException extends RuntimeException {
    private final ResponseStatus exceptionStatus;

    public UserException(ResponseStatus exceptionStatus) {
        super(exceptionStatus.getMessage());
        this.exceptionStatus = exceptionStatus;
    }
}