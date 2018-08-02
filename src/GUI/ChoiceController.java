package GUI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

        this.visitorFacade.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                loadVisitorFacade();
            }
        });

        this.visitorFacade.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                loadVisitorFacade();
            }
        });

        this.employeeFacade.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                loadEmployeeFacade();
            }
        });

        this.employeeFacade.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                loadEmployeeFacade();
            }
        });
    }

    void loadVisitorFacade() {
        Stage stage = (Stage) visitorFacade.getScene().getWindow();;
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("VisitorFacade.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Livraria Beispiel");
        stage.setResizable(true);
        s.changeStage(stage);
    }

    void loadEmployeeFacade() {
        Stage stage = (Stage) employeeFacade.getScene().getWindow();;
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("EmployeeFacade.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Livraria Beispiel");
        stage.setResizable(true);
        s.changeStage(stage);
    }


}
