/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taskmanager.model;

import java.util.Random;

/**
 *
 * @author 02
 */
public class Task {
    private int id = new Random().nextInt(1_000_000)+1;
    private boolean isConcluded = false;
    private String title = "";
    private String description = "";
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public boolean isConcluded() {
        return isConcluded;
    }
    
    public void setConcluded(boolean concluded) {
        this.isConcluded = concluded;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
}
