package dev.marvin.exception;

import dev.marvin.dto.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<ResponseDto<?>> handleDuplicateResourceException(DuplicateResourceException e) {
        log.warn("Duplicate resource error: {}", e.getMessage(), e);
        ResponseDto<Object> responseDto = buildResponse(HttpStatus.CONFLICT.value(), HttpStatus.CONFLICT.getReasonPhrase(), e.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(responseDto);
    }

    @ExceptionHandler(RequestValidationException.class)
    public ResponseEntity<ResponseDto<?>> handleRequestValidationException(RequestValidationException e) {
        log.warn("Bad request error: {}", e.getMessage(), e);
        ResponseDto<Object> responseDto = buildResponse(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDto);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ResponseDto<?>> handleResourceNotFoundException(ResourceNotFoundException e) {
        log.warn("Not found error: {}", e.getMessage(), e);
        ResponseDto<Object> responseDto = buildResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase(), e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDto);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseDto<?>> handleException(Exception e) {
        log.error("Unexpected error occurred: {}", e.getMessage(), e);
        ResponseDto<Object> responseDto = buildResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), "An unexpected error occurred. Please try again later.");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseDto);
    }

    private ResponseDto<Object> buildResponse(Integer statusCode, String status, Object payload) {
        return ResponseDto.builder().statusCode(statusCode).status(status).payload(payload).build();
    }
}
