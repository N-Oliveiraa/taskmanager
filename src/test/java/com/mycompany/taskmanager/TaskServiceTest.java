/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.taskmanager;

import com.mycompany.taskmanager.service.TaskService;
import com.mycompany.taskmanager.exception.TaskException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author 02
 */

public class TaskServiceTest {

    @Test
    void deveAceitarTituloEDescricaoValidos() {

        assertDoesNotThrow(() -> {
            TaskService.validarCampos("Estudar Java", "Praticar testes");
        });
    }

    @Test
    void deveDarErroQuandoTituloForVazio() {

        TaskException erro = assertThrows(TaskException.class,
                () -> TaskService.validarCampos("", "Descrição válida"));

        assertEquals("O título da atividade é obrigatório.",
                erro.getMessage());
    }

    @Test
    void deveDarErroQuandoDescricaoForVazia() {

        TaskException erro = assertThrows(TaskException.class,
                () -> TaskService.validarCampos("Título válido", ""));

        assertEquals("A descrição da atividade é obrigatória.",
                erro.getMessage());
    }
    
    @Test
    void deveDarErroQuandoTituloForNulo(){
        TaskException erro = assertThrows(TaskException.class,
                () -> TaskService.validarCampos(null, "Descrição válida"));
        
        assertEquals("O título da atividade é obrigatório.",
                erro.getMessage());
    }
    
    @Test
    void deveDarErroQuandoDescricaoForNula() {
        TaskException erro = assertThrows(TaskException.class,
            () -> TaskService.validarCampos("Título válido", null));
        
        assertEquals("A descrição da atividade é obrigatória.",
                erro.getMessage());
    }
}
