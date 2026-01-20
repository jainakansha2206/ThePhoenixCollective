package com.thephoenixcollective.user_service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;


@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponse {
    private boolean success;
    private String message;
    private Object data;
    private List<String> errors = Collections.emptyList();


    public UserResponse(boolean success, String message, Object data) {
        this.success = success;
        this.message = message;
        this.data = data;
        this.errors = Collections.emptyList();
    }

    public static UserResponse success(String message, Object data) {
        return new UserResponse(true, message, data);
    }

    public static UserResponse error(String message) {
        return new UserResponse(false, message, null);
    }



}
