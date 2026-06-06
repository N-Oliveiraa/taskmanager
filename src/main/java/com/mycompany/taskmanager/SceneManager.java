/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taskmanager;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author 02
 */
public class SceneManager {
    private static Stage stage;
    
    public static void setStage(Stage primaryStage) {
        stage = primaryStage;
    }
    
    public static void changeScene(String fxml) throws IOException {
        
        Parent root = FXMLLoader.load(SceneManager.class.getResource("/com/mycompany/taskmanager/" + fxml));
        if (stage.getScene() == null) {
            Scene scene = new Scene(root, 1280, 720);
            stage.setScene(scene);
        } else {
            stage.getScene().setRoot(root);
        }
    }
}

