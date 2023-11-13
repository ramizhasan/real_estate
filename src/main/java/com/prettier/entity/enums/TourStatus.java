package com.prettier.entity.enums;


import lombok.Getter;

public enum TourStatus {
    PENDING (0, "Initial value")
    , APPROVED (1, "Can be approved by owner of property")
    ,DECLINED (2, "Can be declined by owner of property")
    ,CANCELED (3, "Can be canceled by guest");


    final int code;
    final String description;

    TourStatus(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }
    public String getDescription() { return description; }

}
