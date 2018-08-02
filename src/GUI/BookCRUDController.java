package GUI;

import business.AdmFacade;
import business.beans.Book;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class BookCRUDController {

    @FXML
    private Button crudBooksButton;

    @FXML
    private Button crudEmployeesButton;

    @FXML
    private Button crudUsersButton;


    @FXML
    private Button finishRegisterBookButton;

    @FXML
    private TextField bookCreateTitleField;

    @FXML
    private TextField bookCreateGenreField;

    @FXML
    private TextField bookCreateAuthorField;

    @FXML
    private TextField bookCreatePriceField;

    @FXML
    private TextField bookCreateYearField;

    @FXML
    private TextField bookCreateCodeField;

    @FXML
    private Button deleteBookButton;

    @FXML
    private TextField bookCodeToDeleteField;

    @FXML
    private TextField importBookCode;

    @FXML
    private TextField amountToImport;

    @FXML
    private Button importBookButton;

    private AdmFacade admFacade = new AdmFacade();

    private System s;

    public void initialize() {
        this.s = System.getInstance();
        this.finishRegisterBookButton.setOnAction(event -> registerBook());
        this.deleteBookButton.setOnAction(event -> deleteBook());
        this.importBookButton.setOnAction(event -> importBook());
        this.crudBooksButton.setOnAction(event -> openBookCRUD());
        this.crudEmployeesButton.setOnAction(event -> openEmployeeCRUD());
        this.crudUsersButton.setOnAction(event -> openUserCRUD());
    }

    private void registerBook() {
        Book aux = new Book();
        aux.setTitle(this.bookCreateTitleField.getText());
        aux.setAuthors(this.bookCreateAuthorField.getText());
        aux.setGenre(this.bookCreateGenreField.getText());
        aux.setCode(this.bookCreateCodeField.getText());
        aux.setYear(Integer.parseInt(this.bookCreateYearField.getText()));
        aux.setAmountAvailable(0);
        aux.setUnitPrice(Double.parseDouble(this.bookCreatePriceField.getText()));
        admFacade.createBook(aux);
        bookCreateTitleField.clear();
        bookCreateAuthorField.clear();
        bookCreateGenreField.clear();
        bookCreateCodeField.clear();
        bookCreateYearField.clear();
        bookCreatePriceField.clear();
    }

    private void deleteBook() {
        ArrayList<Book> auxDelete = admFacade.searchBook(this.bookCodeToDeleteField.getText());
        for (Book anAuxDelete : auxDelete) {
            admFacade.delete(anAuxDelete);
        }
        bookCodeToDeleteField.clear();
    }

    private void importBook() {
        ArrayList<Book> auxImport = admFacade.searchBook(this.importBookCode.getText());
        for (Book anAuxImport : auxImport) {
            String parse = amountToImport.getText();
            admFacade.importBook(Integer.parseInt(parse), anAuxImport);
        }
        importBookCode.clear();
        amountToImport.clear();
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
        s.changeStage(stage);
    }
}
