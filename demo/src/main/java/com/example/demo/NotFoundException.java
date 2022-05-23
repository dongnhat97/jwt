package com.example.demo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class NotFoundException extends Exception {

    public static final String ERROR_NOT_FOUND = "ERROR_NOT_FOUND";
    public static final String ERROR_USER_NOT_FOUND = "ERROR_USER_NOT_FOUND";
    public static final String ERROR_IDENTITY_NOT_FOUND = "ERROR_IDENTITY_NOT_FOUND";
    public static final String ERROR_S3_BUCKET_NOT_FOUND = "ERROR_S3_BUCKET_NOT_FOUND";
    public static final String ERROR_PRODUCT_NOT_FOUND = "ERROR_PRODUCT_NOT_FOUND";
    public static final String ERROR_PRODUCT_DETAIL_NOT_FOUND = "ERROR_PRODUCT_DETAIL_NOT_FOUND";
    public static final String HISTORY_ORDER_NOT_FOUND = "HISTORY_ORDER_NOT_FOUND";
    public static final String ERROR_PRODUCT_ATTRIBUTES_NOT_FOUND = "ERROR_PRODUCT_ATTRIBUTES_NOT_FOUND";
    public static final String ERROR_PRIVATE_KEY_NOT_FOUND = "ERROR_PRIVATE_KEY_NOT_FOUND";
    public static final String ERROR_MASTER_DATA_NOT_FOUND = "ERROR_MASTER_DATA_NOT_FOUND";
    public static final String ERROR_FROM_DATE_BIGGER_TO_DATE = "ERROR_FROM_DATE_BIGGER_TO_DATE";
    public static final String ERROR_FROM_DATE_AND_TO_DATE_NOT_NULL = "ERROR_FROM_DATE_AND_TO_DATE_NOT_NULL";
    public static final String ERROR_LICENSE_NOT_FOUND = "ERROR_LICENSE_NOT_FOUND";
    public static final String ERROR_ORDER_HISTORY_NOT_FOUND = "ERROR_ORDER_HISTORY_NOT_FOUND";
    public static final String ERROR_END_DATE_MUST_BE_BIGGER_THAN_CURRENT_DATE = "ERROR_END_DATE_MUST_BE_BIGGER_THAN_CURRENT_DATE";
    public static final String ERROR_MAINTENANCE_NAME_NOT_FOUND = "ERROR_MAINTENANCE_NAME_NOT_FOUND";
    public static final String ERROR_MASTER_PUBLIC_KEY_NOT_FOUND = "ERROR_MASTER_PUBLIC_KEY_NOT_FOUND";
    public static final String ERROR_MASTER_PUBLIC_KEY_IS_USING = "ERROR_MASTER_PUBLIC_KEY_IS_USING";
    public static final String ERROR_EVENT_NOT_FOUND = "ERROR_EVENT_NOT_FOUND";
    public static final String ERROR_PRODUCT_BID_NOT_FOUND = "ERROR_PRODUCT_BID_NOT_FOUND";
    public static final String ERROR_PRODUCT_BID_HISTORY_NOT_FOUND = "ERROR_PRODUCT_BID_HISTORY_NOT_FOUND";
    public static final String ERROR_PRODUCT_RESELL_NOT_FOUND = "ERROR_PRODUCT_RESELL_NOT_FOUND";
    public static final String ERROR_PRODUCT_OFFER_NOT_FOUND = "ERROR_PRODUCT_OFFER_NOT_FOUND";
    public static final String ERROR_PARENT_PRODUCT_NOT_FOUND = "ERROR_PARENT_PRODUCT_NOT_FOUND";
    public static final String ERROR_APPROVE_FOR_ALL_NOT_CONFIRMED = "ERROR_APPROVE_FOR_ALL_NOT_CONFIRMED";
    public static final String ERROR_SUPPORTER_NOT_FOUND = "ERROR_SUPPORTER_NOT_FOUND";
    public static final String ERROR_ARTIST_NOT_FOUND = "ERROR_ARTIST_NOT_FOUND";

    private static final long serialVersionUID = 1L;
    private String error;
    private String message;
    private HttpStatus httpStatus;
    @JsonIgnore
    private boolean isPrintStackTrace;

    public NotFoundException() {
        super();
    }

    public NotFoundException(String error, String message) {
        super(message);
        this.error = error;
        this.message = message;
    }

    public NotFoundException(String error, String message, HttpStatus httpStatus) {
        super(message);
        this.error = error;
        this.message = message;
        this.httpStatus = httpStatus;
    }
}

