package com.example.web.response;

import java.util.ArrayList;
import java.util.List;

public class ValidationErrorResponse extends ErrorResponse {

    private List<Detail> details;

    public ValidationErrorResponse(String message) {
        super(message);
        details = new ArrayList<>();
    }

    public List<Detail> getDetails() {
        return details;
    }

    public void addDetail(String target, String message) {
        details.add(new Detail(target, message));
    }

    public static class Detail {
        private String target;
        private String message;

        public Detail(String target, String message) {
            this.target = target;
            this.message = message;
        }

        public String getTarget() {
            return target;
        }

        public String getMessage() {
            return message;
        }
    }
}
