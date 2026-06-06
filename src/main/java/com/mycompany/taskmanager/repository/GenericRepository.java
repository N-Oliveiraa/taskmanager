/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taskmanager.repository;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 02
 */
public class GenericRepository<T> {
    private final List<T> items = new ArrayList<>();
    
    public void adicionar(T item) {
        items.add(item);
    }
    
    public void remover(T item) {
        items.remove(item);
    }
    
    public List<T>listarTodos() {
        return items;
    }
    
    public void limpar() {
        items.clear();
    }
}