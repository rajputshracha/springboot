package com.autogeneral.java.restApiang.exception;

import com.autogeneral.java.restApiang.vo.Details;
import com.autogeneral.java.restApiang.vo.ErrorToDo;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        String error = "Must be between 1 and 50 chars long";
        Details det = new Details("param", "text", error, "");
        return buildResponseEntity(new ErrorToDo(det,"ValidationError"),HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<Object> buildResponseEntity(ErrorToDo apiError,HttpStatus status) {
        return new ResponseEntity<>(apiError,status);
    }

    @ExceptionHandler(ToDoItemNotFoundException.class)
    public ResponseEntity<Object> handleToDoNotFoundException(ToDoItemNotFoundException ex, WebRequest request) {
        String errorMessageDesc =  ex.getLocalizedMessage();
        String error = ex.getMessage();
        Details det = new Details(errorMessageDesc);
        return buildResponseEntity(new ErrorToDo(det,"NotFoundError"),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ToDoItemValidationError.class)
    public ResponseEntity<Object> handleInvalidExpressionException(ToDoItemValidationError ex, WebRequest request) {
        String errorMessageDesc =  ex.getLocalizedMessage();
        String error = ex.getMessage();
        Details det = new Details("param","text",errorMessageDesc,"");
        return buildResponseEntity(new ErrorToDo(det,"ValidationError"),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
        public ResponseEntity<Object> handleGenericException(Exception ex, WebRequest wb){
            String messageDescription = ex.getLocalizedMessage();
            if(messageDescription == null) messageDescription = ex.toString();
            return new ResponseEntity<>(messageDescription,new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

}
