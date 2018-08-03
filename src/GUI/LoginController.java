package GUI;

import business.AdmFacade;
import business.beans.User;
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
    private AdmFacade admFacade = new AdmFacade();
    User aux = new User();

    public void initialize() {
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
        this.enterButton.setOnAction(event -> {
            try {
                login();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void login() throws IOException {
        Stage stage = null;
        Parent root = null;
        boolean loginSucceed = false;
        int i;
        for (i = 0; i < admFacade.read().size(); ++i) {
            if (admFacade.read().get(i).getUsername().equals(userField.getText())) {
                aux.setUsername(userField.getText());
                aux.setPassword(admFacade.read().get(i).getPassword());
            }
        }
        if (!aux.getUsername().equals(userField.getText())) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Falha de Login");
            alert.setHeaderText("Informações inválidas.");
            alert.setContentText("Este usuário não possui cadastro no sistema.");
            alert.showAndWait();
        }
        else if (aux.getUsername().equals("adm") && passwordField.getText().equals(aux.getPassword())) {
            stage = (Stage) enterButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("AdmFacade.fxml"));
            loginSucceed = true;
        } else if  (passwordField.getText().equals(aux.getPassword()) && !(aux.getUsername().equals("adm"))) {
            stage = (Stage) enterButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("FacadeChoice.fxml"));
            loginSucceed = true;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Falha no Login");
            alert.setHeaderText("Informações inválidas.");
            alert.setContentText("A senha fornecida está incorreta.");
            alert.showAndWait();
        }

        if (loginSucceed) {
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Livraria Beispiel");
            stage.centerOnScreen();
            s.changeStage(stage);
        }
    }
}

