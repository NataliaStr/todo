package com.in28min.rest.webservices.todo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class TodoEntity {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private boolean isDone;

    private Date targetDate;

    private String username;

    public TodoEntity() {
    }

    public TodoEntity(Long id, String description, boolean isDone, Date targetDate) {
        this.id = id;
        this.description = description;
        this.isDone = isDone;
        this.targetDate = targetDate;
    }

    public TodoEntity(String description, boolean isDone, Date targetDate, String username) {
        this.description = description;
        this.isDone = isDone;
        this.targetDate = targetDate;
        this.username = username;
    }

    public boolean isDone() {
        return this.isDone;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }

    public Long getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    public Date getTargetDate() {
        return this.targetDate;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
