package com.in28min.rest.webservices.todo.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Date;
import java.util.Objects;

@JsonSerialize
public class Todo {
    private Long id;
    private String description;
    private boolean isDone;

    private Date targetDate;

    public Todo(Long id, String description, boolean isDone, Date targetDate) {
        this.id = id;
        this.description = description;
        this.isDone = isDone;
        this.targetDate = targetDate;
    }

    public Todo() {
    }

    public Long getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    public boolean isDone() {
        return this.isDone;
    }

    public Date getTargetDate() {
        return this.targetDate;
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

    public String toString() {
        return "Todo(id=" + this.getId() + ", description=" + this.getDescription() + ", isDone=" + this.isDone() + ", targetDate=" + this.getTargetDate() + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Todo)) return false;
        Todo todo = (Todo) o;
        return isDone == todo.isDone && Objects.equals(id, todo.id) && Objects.equals(description, todo.description) && Objects.equals(targetDate, todo.targetDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, isDone, targetDate);
    }
}
