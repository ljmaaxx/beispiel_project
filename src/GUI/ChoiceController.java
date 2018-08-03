package GUI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

import java.io.IOException;

public class ChoiceController {

    @FXML
    private Button visitorFacade;

    @FXML
    private Button employeeFacade;

    private System s;

    public void initialize(){
        this.s = System.getInstance();

        this.visitorFacade.setOnAction(event -> loadVisitorFacade());
        this.visitorFacade.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                loadVisitorFacade();
            }
        });
        this.employeeFacade.setOnAction(event -> loadEmployeeFacade());
        this.employeeFacade.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                loadEmployeeFacade();
            }
        });
    }

    private void loadVisitorFacade() {
        Stage stage = (Stage) visitorFacade.getScene().getWindow();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("VisitorFacade.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = null;
        if (root != null) {
            scene = new Scene(root);
        }
        stage.setScene(scene);
        stage.setTitle("Livraria Beispiel");
        stage.setResizable(true);
        stage.centerOnScreen();
        s.changeStage(stage);
    }

    private void loadEmployeeFacade() {
        Stage stage = (Stage) employeeFacade.getScene().getWindow();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("EmployeeFacade.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = null;
        if (root != null) {
            scene = new Scene(root);
        }
        stage.setScene(scene);
        stage.setTitle("Livraria Beispiel");
        stage.setResizable(true);
        stage.centerOnScreen();
        s.changeStage(stage);
    }


}
