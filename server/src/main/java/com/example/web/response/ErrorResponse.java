package com.example.web.response;

public class ErrorResponse {

    private String message;

    public ErrorResponse(Exception e) {
        message = e.getMessage();
    }

    public ErrorResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
