package com.raphmei.taskapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String status;


    // Getters et setters
    public String getDescription() {return description;}

    public void setDescription(String description) {this.description = description;}

    public String getTitle() {return title;}

    public void setTitle(String title) {this.title = title;}

    public long getId() {return id;}

    public void setId(long id) {this.id = id;}

    public String getStatus() {return status;}

    public void setStatus(String status) {this.status = status;}


}
