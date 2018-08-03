import GUI.System;
import business.AdmFacade;
import business.beans.Book;
import business.beans.Employee;
import business.beans.User;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        Book one = new Book("Grite", "Jada Smith", 2017, "Horror", "HO5O - J",
                22.89);
        Book two = new Book("O Castelo da Montanha", "Robert James", 1984, "Fantasy",
                "FO88 - R", 98.55);
        Book three = new Book("American Horror Story", "Tabata Northest", 2015, "Romance",
                "RO90- T", 19.99);
        one.setAmountAvailable(1);
        two.setAmountAvailable(1);
        three.setAmountAvailable(10);

        AdmFacade admFacade = new AdmFacade();
        admFacade.createBook(one);
        admFacade.createBook(two);
        admFacade.createBook(three);

        Employee john = new Employee("John Silverstone", 40, "JS4000", 950.00);
        Employee jenna = new Employee("Jenna McAdams", 23, "JM23000", 485.00);
        Employee juan = new Employee("Juan Ramirez", 34, "JR34000", 1859.00);

        admFacade.create(john);
        admFacade.create(jenna);
        admFacade.create(juan);


        User employeeTest = new User("bla", "bla");
        User adm = new User("adm", "senha");
        admFacade.saveUser(employeeTest);
        admFacade.saveUser(adm);
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        System s;
        s = System.getInstance();
        s.start(primaryStage);
    }
}