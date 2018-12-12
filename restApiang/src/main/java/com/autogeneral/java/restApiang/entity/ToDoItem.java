package com.autogeneral.java.restApiang.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;

@Entity
public class ToDoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    @Size(min=2, max = 50 )
    private String text;
    String isCompleted;
    //@CreationTimestamp
    @Column(updatable=false)
    Date createdAt;

    Date createdDate;

    public ToDoItem() {
    }

    public ToDoItem(@NotNull @Size(min = 2, max = 50) String text, String isCompleted, Date createdAt) {
        this.text = text;
        this.isCompleted = isCompleted;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(String isCompleted) {
        this.isCompleted = isCompleted;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ToDoItem toDoItem = (ToDoItem) o;
        return Objects.equals(id, toDoItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ToDoItem{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", isCompleted=" + isCompleted +
                ", createdAt=" + createdAt +
                '}';
    }
}
