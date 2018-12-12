package com.autogeneral.java.restApiang.exception;

import com.autogeneral.java.restApiang.vo.Details;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ToDoItemValidationError extends RuntimeException{

    public ToDoItemValidationError(String message) {
        super(message);
    }

    private Details details;
   String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Details getDetails() {
        return details;
    }

    public void setDetails(Details details) {
        this.details = details;
    }
}
