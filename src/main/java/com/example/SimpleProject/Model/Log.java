package com.example.SimpleProject.Model;

import java.sql.Timestamp;

public class Log {
    private int id;
    private String message;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    private Timestamp createdAt;

//    public Log(int id, String message, Timestamp createdAt) {
//        this.id = id;
//        this.message = message;
//        this.createdAt = createdAt;
//    }

    // Getters and setters
}
