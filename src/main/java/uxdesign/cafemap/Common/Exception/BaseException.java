package uxdesign.cafemap.Common.Exception;

import lombok.Getter;
import uxdesign.cafemap.Common.Response.status.ResponseStatus;

@Getter
public class BaseException extends RuntimeException {
    private final ResponseStatus exceptionStatus;
    public BaseException(ResponseStatus exceptionStatus, String exceptionMessage) {
        super(exceptionMessage);
        this.exceptionStatus = exceptionStatus;
    }
}
