package com.mycompany.taskmanager.controller;

import com.mycompany.taskmanager.SceneManager;
import com.mycompany.taskmanager.repository.TaskRepository;
import com.mycompany.taskmanager.service.TaskService;
import com.mycompany.taskmanager.model.Task;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author 02
 */
public class TelaListagemController {
    @FXML
    private VBox containerTasks;
    
    @FXML
    private Label totalLabel;

    @FXML
    private Label pendentesLabel;

    @FXML
    private Label concluidasLabel;
    
    @FXML
    private ComboBox<String> comboFiltro;
    
    @FXML
    private void irParaCadastro() throws IOException {
        TaskRepository.taskEmEdicao = null;
        SceneManager.changeScene("TelaCadastro.fxml");
    }
    
    @FXML
    private void initialize() {
        for (Task task : TaskService.listar()){
            adicionarTask(task);
        }
        
        atualizarContadores();
        
        comboFiltro.getItems().addAll(
            "Total",
            "Pendentes",
            "Concluídas"
        );

        comboFiltro.setValue("Total");
    }
    
    
    public void adicionarTask(Task task) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/mycompany/taskmanager/TaskCard.fxml"));
            HBox card = loader.load();
            
            TaskCardController controller = loader.getController();
            controller.setTask(task);
            
            controller.setTelaListagemController(this);
            
            containerTasks.getChildren().add(card);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void atualizarContadores() {

        int total = TaskService.listar().size();

        int concluidas = 0;

        for (Task task : TaskService.listar()) {
            if (task.isConcluded()) {
                concluidas++;
            }
        }

        int pendentes = total - concluidas;

        totalLabel.setText(String.valueOf(total));
        pendentesLabel.setText(String.valueOf(pendentes));
        concluidasLabel.setText(String.valueOf(concluidas));
    }
    
    @FXML
    private void filtrarTarefas() {
        
        containerTasks.getChildren().clear();

        String filtro = comboFiltro.getValue();

        for (Task task : TaskService.listar()) {

            if ("Total".equals(filtro)) {
                adicionarTask(task);
            }

            else if ("Pendentes".equals(filtro)
                    && !task.isConcluded()) {

                adicionarTask(task);
            }

            else if ("Concluídas".equals(filtro)
                    && task.isConcluded()) {

                adicionarTask(task);
            }
        }
    }   
}
