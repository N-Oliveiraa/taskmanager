package com.mycompany.taskmanager;

import com.mycompany.taskmanager.dao.DatabaseConnection;
import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;
import java.sql.Connection;
import static javafx.application.Application.launch;

/**
 *
 * @author 02
 */
public class TaskManager extends Application{
    
    @Override
    public void start(Stage stage) throws IOException {
        SceneManager.setStage(stage);
        SceneManager.changeScene("TelaListagem.fxml");
        stage.setTitle("Tela de listagem");
        stage.show();
    }

    public static void main(String[] args) {
        try {
            Connection connection = DatabaseConnection.getConnection();
            System.out.print("Conectado com sucesso");
        } catch(Exception e) {
           System.out.print("Não conectou"); 
        }
        launch(args);
    }   
}