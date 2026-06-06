/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taskmanager;

import com.mycompany.taskmanager.dao.TaskDAO;
import com.mycompany.taskmanager.model.Task;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author 02
 */
public class TaskDAOTest {
    private Task taskTeste;

    @BeforeEach
    void prepararTeste() {
        taskTeste = new Task();
        taskTeste.setTitle("Tarefa Teste");
        taskTeste.setDescription("Descrição Teste");

        TaskDAO.salvar(taskTeste);

        taskTeste = buscarUltimaTask();
    }

    @AfterEach
    void limparTeste() {
        if (taskTeste != null) {
            TaskDAO.excluir(taskTeste.getId());
        }
    }

    @Test
    void deveSalvarTaskNoBanco() {
        assertNotNull(taskTeste);
        assertTrue(taskTeste.getId() > 0);
        assertEquals("Tarefa Teste", taskTeste.getTitle());
        assertEquals("Descrição Teste", taskTeste.getDescription());
    }

    @Test
    void deveListarTasksDoBanco() {
        List<Task> tasks = TaskDAO.listar();

        assertNotNull(tasks);
        assertFalse(tasks.isEmpty());
    }

    @Test
    void deveAtualizarTaskNoBanco() {
        TaskDAO.atualizarTask(
                taskTeste.getId(),
                "Título Atualizado",
                "Descrição Atualizada"
        );

        Task taskAtualizada = buscarTaskPorId(taskTeste.getId());

        assertNotNull(taskAtualizada);
        assertEquals("Título Atualizado", taskAtualizada.getTitle());
        assertEquals("Descrição Atualizada", taskAtualizada.getDescription());
    }

    @Test
    void deveAtualizarStatusDaTaskNoBanco() {
        TaskDAO.atualizarStatus(taskTeste.getId(), true);

        Task taskAtualizada = buscarTaskPorId(taskTeste.getId());

        assertNotNull(taskAtualizada);
        assertTrue(taskAtualizada.isConcluded());
    }

    @Test
    void deveExcluirTaskDoBanco() {
        int id = taskTeste.getId();

        TaskDAO.excluir(id);

        taskTeste = null;

        Task taskExcluida = buscarTaskPorId(id);

        assertNull(taskExcluida);
    }

    private Task buscarUltimaTask() {
        List<Task> tasks = TaskDAO.listar();

        assertFalse(tasks.isEmpty());

        return tasks.get(tasks.size() - 1);
    }

    private Task buscarTaskPorId(int id) {
        for (Task task : TaskDAO.listar()) {
            if (task.getId() == id) {
                return task;
            }
        }

        return null;
    }
}
