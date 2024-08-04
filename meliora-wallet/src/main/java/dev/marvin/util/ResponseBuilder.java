package dev.marvin.util;

import dev.marvin.dto.ResponseDto;

public class ResponseBuilder {
    public static ResponseDto<Object> buildResponse(Integer statusCode, String status, Object payload) {
        return ResponseDto.builder().statusCode(statusCode).status(status).payload(payload).build();
    }
}
