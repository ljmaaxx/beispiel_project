package GUI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class AdmFacadeController {

    private System s;
    @FXML
    private Button crudBooksButton;

    @FXML
    private Button crudEmployeesButton;

    @FXML
    private Button crudUsersButton;


    public void initialize() {
        this.s = System.getInstance();
        this.crudBooksButton.setOnAction(event -> openBookCRUD());
        this.crudEmployeesButton.setOnAction(event -> openEmployeeCRUD());
        this.crudUsersButton.setOnAction(event -> openUserCRUD());
    }

    private void openBookCRUD() {
        Stage stage = (Stage) crudBooksButton.getScene().getWindow();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("BookCRUD.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = null;
        if (root != null) {
            scene = new Scene(root);
        }
        stage.setScene(scene);
        stage.setTitle("Livros - Livraria Beispiel");
        stage.centerOnScreen();
        s.changeStage(stage);
    }

    private void openEmployeeCRUD() {
        Stage stage = (Stage) crudEmployeesButton.getScene().getWindow();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("EmployeeCRUD.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = null;
        if (root != null) {
            scene = new Scene(root);
        }
        stage.setScene(scene);
        stage.setTitle("Funcionáios - Livraria Beispiel");
        stage.centerOnScreen();
        s.changeStage(stage);
    }

    private void openUserCRUD() {
        Stage stage = (Stage) crudUsersButton.getScene().getWindow();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("UserCRUD.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = null;
        if (root != null) {
            scene = new Scene(root);
        }
        stage.setScene(scene);
        stage.setTitle("Usuários - Livraria Beispiel");
        stage.centerOnScreen();
        s.changeStage(stage);
    }
}

