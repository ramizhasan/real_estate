package com.prettier.entity.enums;

import jakarta.persistence.Entity;

public enum Status {
    PENDING(0, "The advert was created and waiting for administrative approval"),
    ACTIVATED(1, "The advert was approved by admin or manager users and everyone can see it"),
    REJECTED(2, "The advert was rejected by admin or manager users");

    private final int statusCode;
    private final String explanation;

    Status(int statusCode, String explanation) {
        this.statusCode = statusCode;
        this.explanation = explanation;
    }

    int getStatusCode(){ return this.statusCode; }
    String getExplanation() { return this.explanation; }


}
