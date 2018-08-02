package GUI;

import business.AdmFacade;
import business.beans.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private Button enterButton;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField userField;

    private System s;
    private User userAdm = new User("adm", "senha");
    private AdmFacade admFacade = new AdmFacade();

    public void initialize(){
        this.s = System.getInstance();
        //admFacade.saveUser(userAdm);

        this.passwordField.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                try {
                    login();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        this.enterButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    login();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void login() throws IOException {
        User employeeTest = new User("bla", "bla");
        admFacade.saveUser(employeeTest);
        Stage stage = null;
        Parent root = null;
        boolean loginSucceed = false;
        if(userField.getText().equals(userAdm.getUsername())) {
            if (passwordField.getText().equals(userAdm.getPassword())) {
                stage = (Stage) enterButton.getScene().getWindow();
//                root = FXMLLoader.load(getClass().getResource("AdmFacade.fxml"));
                root = FXMLLoader.load(getClass().getResource("teste.fxml"));
                loginSucceed = true;
            }
        }

        //TODO ??
        else if (true) {
            for (int i = 0; i < admFacade.read().size(); ++i) {
                if (admFacade.read().get(i).getUsername().equals(userField.getText())) {
                    if (passwordField.getText().equals(admFacade.read().get(i).getPassword())) {
                        stage = (Stage) enterButton.getScene().getWindow();
                        root = FXMLLoader.load(getClass().getResource("FacadeChoice.fxml"));
                        loginSucceed = true;
                    }
                }
            }
        }
        /*else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Falha no Login");
            alert.setHeaderText("Informações inválidas.");
            alert.setContentText("A senha fornecida está incorreta.");
            alert.showAndWait();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Falha de Login");
            alert.setHeaderText("Informações inválidas.");
            alert.setContentText("Este usuário não possui cadastro no sistema.");
            alert.showAndWait();
        }*/
        if(loginSucceed){
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Administrador");
            s.changeStage(stage);
        }
    }
}
