package uxdesign.cafemap.Common.Response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import uxdesign.cafemap.Common.Response.status.ResponseStatus;

import static uxdesign.cafemap.Common.Response.status.BaseExceptionResponseStatus.SUCCESS;

@Getter
@JsonPropertyOrder({"code", "status", "message", "result"})
public class BaseResponse<T> implements ResponseStatus {

    private final int code;
    private final int status;
    private final String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final T result;

    public BaseResponse(T result) {
        this.code = SUCCESS.getCode();
        this.status = SUCCESS.getStatus();
        this.message = SUCCESS.getMessage();
        this.result = result;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public int getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
