package lk.easy_car_rental.advisor;

import lk.easy_car_rental.util.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
@CrossOrigin
public class AppWideExceptionHandler {
    @ExceptionHandler({RuntimeException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseUtil handleException(RuntimeException e) {
        return new ResponseUtil("Error", e.getMessage(), null);
    }
}
