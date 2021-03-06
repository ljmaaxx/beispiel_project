package GUI;

import business.AdmFacade;
import business.beans.Book;
import business.beans.Employee;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class System extends Application {

    private static System instance;
    private AdmFacade facade = new AdmFacade();

    public static System getInstance(){
        if(instance == null){
            instance = new System();
        }
        return instance;
    }

    private Stage primaryStage;
    private Pane rootScene;

    @Override
    public void start(Stage primaryStage) {
        instance = this;
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Login");
        this.rootScene = new Pane();
        Scene scene = new Scene(this.rootScene, 301, 170);
        this.primaryStage.setScene(scene);
        this.primaryStage.show();
        //this.loadBooks();
        //this.loadEmployees();
        primaryStage.centerOnScreen();
        this.openLoginScreen();
    }

    private void loadBooks(){
        Book one = new Book("Grite", "Jada Smith", 2017, "Horror", "HO5O - J",
                22.89);
        Book two = new Book("O Castelo da Montanha", "Robert James", 1984, "Fantasy",
                "FO88 - R", 98.55 );
        Book three = new Book("O Último Flamingo do Lago", "Tabata Northest", 2015, "Romance",
                "RO90- T", 19.99);
        one.setAmountAvailable(1);
        two.setAmountAvailable(1);
        three.setAmountAvailable(10);

        facade.createBook(one);
        facade.createBook(two);
        facade.createBook(three);
    }

    private void loadEmployees() {
        Employee john = new Employee("John Silverstone", 40, "JS4000", 950.00);
        Employee jenna = new Employee("Jenna McAdams", 23, "JM23000", 485.00);
        Employee juan = new Employee("Juan Ramirez", 34, "JR34000", 1859.00);

        facade.create(john);
        facade.create(jenna);
        facade.create(juan);
    }

    private void openLoginScreen(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(System.class.getResource("loginScreen.fxml"));
            Pane pane = loader.load();
            this.rootScene.getChildren().add(pane);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    protected void changeStage(Stage stage){
        this.primaryStage = stage;
    }

    public Stage getPrimaryStage(){
        return this.primaryStage;
    }

    public static void main (String[] args){
        launch(args);
    }
}