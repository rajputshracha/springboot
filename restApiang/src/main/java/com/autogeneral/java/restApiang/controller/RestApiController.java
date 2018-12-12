package com.autogeneral.java.restApiang.controller;

import com.autogeneral.java.restApiang.entity.ToDoItem;
import com.autogeneral.java.restApiang.exception.ToDoItemValidationError;
import com.autogeneral.java.restApiang.repository.ToDoRepository;
import com.autogeneral.java.restApiang.utils.RestApiUtil;
import com.autogeneral.java.restApiang.exception.ToDoItemNotFoundException;
import com.autogeneral.java.restApiang.vo.Expressions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.Optional;

@RestController
public class RestApiController {

    @Autowired
    private final ToDoRepository toDoRepository;

    public RestApiController(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    @GetMapping(value = "/tasks/validateBrackets/{expression}")
    public ResponseEntity<?> validateExpressions(@Valid @PathVariable("expression") String expression){
        Expressions ex = new Expressions();

        if(expression.length() <= 1 || expression.length() > 50){
            throw new ToDoItemValidationError("Must be between 1 and 50 chars long");
        }
        if(RestApiUtil.validateExpression(expression)){
            ex.setIsBalanced(Boolean.TRUE.toString());
        }else  ex.setIsBalanced(Boolean.FALSE.toString());
        ex.setExpression(expression);

        return new ResponseEntity<Object>(ex,HttpStatus.OK);
    }

    @PostMapping("/todo")
    public ResponseEntity<?> addToDoItem(@Valid @RequestBody ToDoItem param){
        param.setCreatedAt(new Date());
        param.setIsCompleted(Boolean.FALSE.toString());
        ToDoItem item = toDoRepository.save(param);
        return new ResponseEntity<Object>(item, HttpStatus.OK);
    }

    @GetMapping(value = "/todo/{id}")
    public ResponseEntity<?> validateToDo(@PathVariable("id") Long id){
        Optional<ToDoItem> item = toDoRepository.findById(id);
        if(!item.isPresent()) throw  new ToDoItemNotFoundException("Item with "+ id +" not found");
        return new ResponseEntity<Object>(item, HttpStatus.OK);

    }

    @GetMapping(value = "/todo/all")
    public ResponseEntity<?> fetchToDo() throws Exception{
           return new ResponseEntity<Object>(toDoRepository.findAll(), HttpStatus.OK);
    }

    @PutMapping("/todo/{id}")
    public ResponseEntity<Object> updateToDo(@Valid @RequestBody ToDoItem item, @PathVariable long id) {
        Optional<ToDoItem> findItem = toDoRepository.findById(id);
        if(!findItem.isPresent()) throw  new ToDoItemNotFoundException("Item with "+ id +" not found");
        item.setId(id);
        ToDoItem saveItem = toDoRepository.save(item);
        return new ResponseEntity<Object>(saveItem, HttpStatus.OK);
    }

}


