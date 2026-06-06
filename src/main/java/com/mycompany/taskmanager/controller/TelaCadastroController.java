package com.mycompany.taskmanager.controller;

import com.mycompany.taskmanager.SceneManager;
import com.mycompany.taskmanager.repository.TaskRepository;
import com.mycompany.taskmanager.service.TaskService;
import com.mycompany.taskmanager.model.Task;
import com.mycompany.taskmanager.exception.TaskException;
import com.mycompany.taskmanager.util.AlertUtil;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;



/**
 *
 * @author 02
 */
public class TelaCadastroController {
    @FXML
    private TextField campoTitulo;
    
    @FXML
    private TextArea campoDescricao;
    
    @FXML
    private Button btnSalvar;
    
    @FXML
    private void initialize() {
        if (TaskRepository.taskEmEdicao != null) {
            campoTitulo.setText(TaskRepository.taskEmEdicao.getTitle());
            campoDescricao.setText(TaskRepository.taskEmEdicao.getDescription());
           
            btnSalvar.setText("Editar");
              
            btnSalvar.getStyleClass().remove("btn-criar");
            btnSalvar.getStyleClass().add("btn-editar");
        } else {
            
            btnSalvar.setText("Salvar");
            
            btnSalvar.getStyleClass().remove("btn-editar"); 
            btnSalvar.getStyleClass().add("btn-salvar");
        }
    }
    @FXML
    private void salvarTask() throws IOException {    
        String titulo = campoTitulo.getText().trim();
        String descricao = campoDescricao.getText().trim();
        
        try{
    
            if (TaskRepository.taskEmEdicao == null) {
                
                Task novaTask = new Task();
                novaTask.setTitle(titulo);
                novaTask.setDescription(descricao);

                TaskService.salvar(novaTask);            
            }else {
                
                Task task = TaskRepository.taskEmEdicao;

                task.setTitle(titulo);
                task.setDescription(descricao);
                
                TaskService.atualizar(task);

                TaskRepository.taskEmEdicao = null;  
            }
            
            SceneManager.changeScene("TelaListagem.fxml");
            
        } catch(TaskException e) {
            AlertUtil.alertaErro(e.getMessage());       
        }           
    }
    
    @FXML
    public void cancelar() throws IOException {
        TaskRepository.taskEmEdicao = null;
        
        SceneManager.changeScene("TelaListagem.fxml");
    }
}