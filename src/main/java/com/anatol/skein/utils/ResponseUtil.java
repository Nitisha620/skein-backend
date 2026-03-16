package com.anatol.skein.utils;

import com.anatol.skein.shared.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseUtil {

    // SUCCESS - 200
    public static <T> ResponseEntity<?> success(T resBody) {
        return new ResponseEntity<>(
                new ResponseDTO<>(true, "Success", resBody), HttpStatus.OK);
    }

    // CREATED - 201
    public static <T> ResponseEntity<?> create(T resBody) {
        return new ResponseEntity<>(
                new ResponseDTO<>(true, "Created Successfully", resBody), HttpStatus.CREATED);
    }

    // BAD REQUEST - 400
    public static <T> ResponseEntity<?> badRequest(String message) {
        return new ResponseEntity<>(
                new ResponseDTO<>(false, message, null), HttpStatus.BAD_REQUEST);
    }

    // UNAUTHORIZED - 401
    public static <T> ResponseEntity<?> unauthorized() {
        return new ResponseEntity<>(
                new ResponseDTO<>(false, "Authorization failed", null), HttpStatus.UNAUTHORIZED);
    }

    // NOT FOUND - 404
    public static <T> ResponseEntity<?> notFound(String message) {
        return new ResponseEntity<>(
                new ResponseDTO<>(false, message, null), HttpStatus.NOT_FOUND);
    }

    // INTERNAL SERVER ERROR - 500
    public static <T> ResponseEntity<?> internalServerError(String message) {
        return new ResponseEntity<>(
                new ResponseDTO<>(false, message, null), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public static ResponseEntity<?> error(String message, HttpStatus status) {
        return new ResponseEntity<>(
                new ResponseDTO<>(false, message, null), status);
    }
}
