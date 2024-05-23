package agency.travel.com.example.sitetravel.config;

import agency.travel.com.example.sitetravel.exceptions.AvailableOfRoomsException;
import agency.travel.com.example.sitetravel.exceptions.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;


@ControllerAdvice
public class ExceptionHandlerAdvice {
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleNotFoundException(NotFoundException ex, WebRequest request) {
        return handleException(ex, request, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AvailableOfRoomsException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleNotFoundException(AvailableOfRoomsException ex, WebRequest request) {
        return handleException(ex, request, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Object> handleInternalServerError(Exception ex, WebRequest request) {
        return handleException(ex, request, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<Object> handleException(Exception ex, WebRequest request, HttpStatus status) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, status);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class ExceptionResponse {
        private Date timestamp;
        private String message;
        private String details;


    }
}
