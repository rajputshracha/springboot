package com.autogeneral.java.restApiang.vo;

public class ErrorToDo {

    private Details details;
    private String name;

    public ErrorToDo(Details details, String name) {
        this.details = details;
        this.name = name;
    }

    public ErrorToDo() {
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
