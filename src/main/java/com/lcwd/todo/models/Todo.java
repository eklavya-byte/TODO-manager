package com.lcwd.todo.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Todo {

    private  int id;
    private String title;
    private String content;
    private String status; // here we can use enum as well
    @JsonFormat(pattern = "dd/MM/YYYY")
    private Date addedDate;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date toDoDate;
    public Todo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public Date getToDoDate() {
        return toDoDate;
    }

    public void setToDoDate(Date toDoData) {
        this.toDoDate = toDoData;
    }

    public Todo(int id, String title, String content, String status, Date addedDate, Date toDoData) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.status = status;
        this.addedDate = addedDate;
        this.toDoDate = toDoData;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", status='" + status + '\'' +
                ", addedDate=" + addedDate +
                ", toDoData=" + toDoDate +
                '}';
    }

}
