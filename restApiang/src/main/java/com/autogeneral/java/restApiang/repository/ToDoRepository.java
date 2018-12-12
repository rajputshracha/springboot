package com.autogeneral.java.restApiang.repository;

import com.autogeneral.java.restApiang.entity.ToDoItem;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ToDoRepository extends JpaRepository<ToDoItem,Long> {
}
