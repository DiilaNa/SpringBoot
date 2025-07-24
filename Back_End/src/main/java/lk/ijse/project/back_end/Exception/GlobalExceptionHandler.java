package lk.ijse.project.back_end.Exception;

import lk.ijse.project.back_end.util.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> HandleGenericException(Exception e){
        return new ResponseEntity<>(new ApiResponse(500,e.getMessage(),null),HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
