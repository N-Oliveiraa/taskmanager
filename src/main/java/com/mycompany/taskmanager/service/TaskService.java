/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taskmanager.service;

import com.mycompany.taskmanager.dao.TaskDAO;
import com.mycompany.taskmanager.model.Task;
import com.mycompany.taskmanager.exception.TaskException;
import java.util.List;


/**
 *
 * @author 02
 */
public class TaskService {
    public static void validarCampos(String titulo, String descricao) throws TaskException {

        if (titulo == null || titulo.trim().isEmpty()) {
            throw new TaskException("O título da atividade é obrigatório.");
        }

        if (descricao == null || descricao.trim().isEmpty()) {
            throw new TaskException("A descrição da atividade é obrigatória.");
        }
    }
    
    public static void salvar(Task task) throws TaskException {
        validarCampos(task.getTitle(), task.getDescription());
        TaskDAO.salvar(task);
    }
    
    public static void atualizar(Task task) throws TaskException {
        validarCampos(task.getTitle(), task.getDescription());

        TaskDAO.atualizarTask(
                task.getId(),
                task.getTitle(),
                task.getDescription()
        );
    }
    
    public static List<Task> listar() {
        return TaskDAO.listar();
    }
    
    public static void excluir(int id) {
        TaskDAO.excluir(id);
    }
    
    public static void atualizarStatus(int id, boolean concluida) {
        TaskDAO.atualizarStatus(id, concluida);
    }
}