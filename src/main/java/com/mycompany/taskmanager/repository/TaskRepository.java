/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taskmanager.repository;

import com.mycompany.taskmanager.model.Task;

/**
 *
 * @author 02
 */
public class TaskRepository {
    public static GenericRepository<Task> tasks = new GenericRepository<>();
    public static Task taskEmEdicao = null;
}
