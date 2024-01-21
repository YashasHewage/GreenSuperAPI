package com.greensuper.GreenSuper.dto;

import lombok.Data;

@Data
public class ApiResponse {

    public String message;
    private boolean success;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
    public ApiResponse() {
        super();
    }

    public ApiResponse(String message, boolean success) {
        this.message = message;
        this.success = success;
    }
}
