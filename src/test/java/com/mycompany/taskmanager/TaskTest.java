/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taskmanager;

import com.mycompany.taskmanager.model.Task;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author 02
 */
public class TaskTest {
    @Test
    void deveCriarTaskComSucesso(){
        Task task = new Task();
        
        task.setTitle("Estudar Java");
        task.setDescription("Praticar JavaFX, DEITEL");
        
        assertEquals("Estudar Java", task.getTitle());
        
        assertEquals("Praticar JavaFX, DEITEL", task.getDescription());        
    }
    
    @Test
    void deveMarcarComoConcluida(){
        Task task = new Task();
        
        task.setConcluded(true);
        
        assertTrue(task.isConcluded());
    }
}
