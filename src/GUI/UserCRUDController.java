package GUI;

import business.AdmFacade;
import business.beans.Employee;
import business.beans.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class UserCRUDController {

    @FXML
    private Button crudBooksButton;

    @FXML
    private Button crudEmployeesButton;

    @FXML
    private Button crudUsersButton;


    @FXML
    private Button createUserButton;

    @FXML
    private TextField createUserEmployeeFieldName;

    @FXML
    private TextField createUserEmployeeFieldAge;

    @FXML
    private TextField createUserEmployeeFieldCode;

    @FXML
    private TextField createUserEmployeeFieldSalary;

    @FXML
    private Button searchCodeToCreateUserButton;

    @FXML
    private TextField codeToCreateUserField;

    @FXML
    private TextField createUserField;

    @FXML
    private TextField createPasswordField;

    @FXML
    private Button deleteUserButton;

    @FXML
    private TextField deleteUserEmployeeFieldName;

    @FXML
    private TextField deleteUserEmployeeFieldAge;

    @FXML
    private TextField deleteUserEmployeeFieldCode;

    @FXML
    private TextField deleteUserEmployeeFieldSalary;

    @FXML
    private Button searchUserToDeleteButton;

    @FXML
    private TextField codeUserToDeleteField;

    @FXML
    private TextField deletePasswordField;

    @FXML
    private TextField deleteUserField;

    private AdmFacade admFacade = new AdmFacade();

    private Employee auxEmployee = new Employee();

    private User auxUser = new User();

    private System s;

    public void initialize(){
        this.s = System.getInstance();
        this.searchCodeToCreateUserButton.setOnAction(event -> loadDataCreate());
        this.createUserButton.setOnAction(event -> registerUser());
        this.searchUserToDeleteButton.setOnAction(event -> loadDataDelete());
        this.deleteUserButton.setOnAction(event -> deleteUser());
        this.crudBooksButton.setOnAction(event -> openBookCRUD());
        this.crudEmployeesButton.setOnAction(event -> openEmployeeCRUD());
        this.crudUsersButton.setOnAction(event -> openUserCRUD());
    }

    private void loadDataCreate() {
        auxEmployee = admFacade.searchEmployee(codeToCreateUserField.getText());
        this.createUserEmployeeFieldName.setText(auxEmployee.getName());
        this.createUserEmployeeFieldAge.setText(Integer.toString(auxEmployee.getAge()));
        this.createUserEmployeeFieldCode.setText(auxEmployee.getIdCode());
        this.createUserEmployeeFieldSalary.setText(Double.toString(auxEmployee.getSalary()));
    }

    private void loadDataDelete() {
        auxEmployee = admFacade.searchEmployee(codeUserToDeleteField.getText());
        this.deleteUserEmployeeFieldName.setText(auxEmployee.getName());
        this.deleteUserEmployeeFieldAge.setText(Integer.toString(auxEmployee.getAge()));
        this.deleteUserEmployeeFieldCode.setText(auxEmployee.getIdCode());
        this.deleteUserEmployeeFieldSalary.setText(Double.toString(auxEmployee.getSalary()));
    }

    private void registerUser() {
        auxUser.setUsername(createUserField.getText());
        auxUser.setPassword(createPasswordField.getText());
        admFacade.saveUser(auxUser);
        auxEmployee = admFacade.searchEmployee(codeToCreateUserField.getText());
        auxEmployee.setSystemUser(auxUser);
        createUserField.clear();
        createPasswordField.clear();
        codeToCreateUserField.clear();
        createUserEmployeeFieldName.clear();
        createUserEmployeeFieldAge.clear();
        createUserEmployeeFieldCode.clear();
        createUserEmployeeFieldSalary.clear();
    }

    private void deleteUser() {
        auxUser = admFacade.searchByUser(deleteUserField.getText());
        admFacade.delete(auxUser);
        codeUserToDeleteField.clear();
        deleteUserField.clear();
        deletePasswordField.clear();
        deleteUserEmployeeFieldName.clear();
        deleteUserEmployeeFieldAge.clear();
        deleteUserEmployeeFieldCode.clear();
        deleteUserEmployeeFieldSalary.clear();
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
