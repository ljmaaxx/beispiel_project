package GUI;

import business.AdmFacade;
import business.beans.Employee;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class EmployeeCRUDController {

    @FXML
    private Button crudBooksButton;

    @FXML
    private Button crudEmployeesButton;

    @FXML
    private Button crudUsersButton;


    @FXML
    private Button createEmployeeButton;

    @FXML
    private TextField createEmployeeFieldName;

    @FXML
    private TextField createEmployeeFieldAge;

    @FXML
    private TextField createEmployeeFieldCode;

    @FXML
    private TextField createEmployeeFieldSalary;

    @FXML
    private Button deleteEmployeeButton;

    @FXML
    private TextField deleteEmployeeFieldCodeToDelete;

    private AdmFacade admFacade = new AdmFacade();

    private System s;

    public void initialize(){
        this.s = System.getInstance();
        this.createEmployeeButton.setOnAction(event -> registerEmployee());
        this.deleteEmployeeButton.setOnAction(event -> deleteEmployee());
        this.crudBooksButton.setOnAction(event -> openBookCRUD());
        this.crudEmployeesButton.setOnAction(event -> openEmployeeCRUD());
        this.crudUsersButton.setOnAction(event -> openUserCRUD());
    }

    private void registerEmployee() {
        Employee aux = new Employee();
        aux.setName(this.createEmployeeFieldName.getText());
        aux.setAge(Integer.parseInt(this.createEmployeeFieldAge.getText()));
        aux.setIdCode(this.createEmployeeFieldCode.getText());
        aux.setSalary(Double.parseDouble(this.createEmployeeFieldSalary.getText()));
        admFacade.create(aux);
        //TODO alert window
        createEmployeeFieldName.clear();
        createEmployeeFieldAge.clear();
        createEmployeeFieldCode.clear();
        createEmployeeFieldSalary.clear();
    }

    private void deleteEmployee() {
        admFacade.delete(admFacade.searchEmployee(deleteEmployeeFieldCodeToDelete.getText()));
        deleteEmployeeFieldCodeToDelete.clear();
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
