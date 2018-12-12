package com.autogeneral.java.restApiang.exception;

import com.autogeneral.java.restApiang.vo.Details;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ToDoItemNotFoundException extends RuntimeException{

    Details details;
    String name;

    public ToDoItemNotFoundException(String message) {
        super(message);
    }

    public ToDoItemNotFoundException(String message, Details details, String name) {
        super(message);
        this.details = details;
        this.name = name;
    }
    public ToDoItemNotFoundException(Details details, String name) {
        this.details = details;
        this.name = name;
    }

    public Details getDetails() {
        return details;
    }

    public void setDetails(Details details) {
        this.details = details;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
