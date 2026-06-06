/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taskmanager.controller;

import com.mycompany.taskmanager.SceneManager;
import com.mycompany.taskmanager.repository.TaskRepository;
import com.mycompany.taskmanager.service.TaskService;
import com.mycompany.taskmanager.model.Task;
import com.mycompany.taskmanager.util.AlertUtil;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


/**
 *
 * @author 02
 */
public class TaskCardController {
    @FXML
    private Label tituloLabel;
    
    @FXML
    private Label descricaoLabel;
    
    @FXML
    private HBox taskCard;
    
    @FXML
    private CheckBox checkBoxTask;
    
    private Task task;
    
    private TelaListagemController telaListagemController;

    public void setTask(Task task) {
        this.task = task;
        
        tituloLabel.setWrapText(true);
        descricaoLabel.setWrapText(true);
        
        tituloLabel.setText(task.getTitle());
        descricaoLabel.setText(task.getDescription());
        checkBoxTask.setSelected(task.isConcluded());
    }
    
    @FXML
    private void excluirTask() {
        boolean confirmou = AlertUtil.confirmarExclusao(task.getTitle());
        
        if (confirmou) {
            
            TaskService.excluir(task.getId());
        
            VBox containerTasks = (VBox) taskCard.getParent();
            containerTasks.getChildren().remove(taskCard);        
        }
        
        telaListagemController.atualizarContadores();
    }
    
    @FXML
    private void alterarStatusTask() {
        boolean novoStatus = checkBoxTask.isSelected();
        
        task.setConcluded(novoStatus);
        TaskService.atualizarStatus(task.getId(), novoStatus);
        
        telaListagemController.atualizarContadores();
    }
    
    @FXML
    private void editarTask() throws IOException {
        TaskRepository.taskEmEdicao = task;
        SceneManager.changeScene("TelaCadastro.fxml");
    }
    
    public void setTelaListagemController(TelaListagemController controller) {
        this.telaListagemController = controller;
    }
}
