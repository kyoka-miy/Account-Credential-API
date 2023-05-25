package com.example.recruit.response;

public class ApiErrorResponse {
    private String message;
    private String cause;

    public ApiErrorResponse() {
    }

    public ApiErrorResponse(String message, String cause) {
        this.message = message;
        this.cause = cause;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }
}
