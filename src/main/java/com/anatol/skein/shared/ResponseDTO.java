package com.anatol.skein.shared;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ResponseDTO<T> {
    private boolean success;
    private String message;
    private T data;
}
