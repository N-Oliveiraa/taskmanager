/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taskmanager.util;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;


/**
 *
 * @author 02
 */
public class AlertUtil {
    public static void alertaCamposObrigatorios() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Campos obrigatórios");
        alert.setHeaderText("Preencha todos os campos");
        alert.setContentText("O título e a descrição da atividade são obrigatórios.");
        alert.showAndWait();
    }

    public static boolean confirmarExclusao(String tituloAtividade) {
        ButtonType btnConfirmar = new ButtonType("Ok");
        ButtonType btnCancelar = new ButtonType("Cancelar");

        Alert alert = new Alert(
                Alert.AlertType.CONFIRMATION,
                "Deseja realmente excluir a atividade:\n\n" + tituloAtividade
                + "\n\nEsta ação não poderá ser desfeita.",
                btnConfirmar,
                btnCancelar
        );

        alert.setTitle("Confirmação");
        alert.setHeaderText("Excluir atividade");

        alert.getDialogPane().lookupButton(btnConfirmar).setStyle(
                "-fx-background-color: #e74c3c;"
                + "-fx-text-fill: white;"
        );

        alert.getDialogPane().lookupButton(btnCancelar).setStyle(
                "-fx-background-color: #3498db;"
                + "-fx-text-fill: white;"
        );

        Optional<ButtonType> resultado = alert.showAndWait();

        return resultado.isPresent() && resultado.get() == btnConfirmar;
    }

    public static void alertaErro(String mensagem) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setHeaderText("Ocorreu um erro");
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}
