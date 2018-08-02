package GUI;

import business.AdmFacade;
import business.beans.Book;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class AdmFacadeController {

//    private Stage root;
    @FXML private Button crudBooksButton;
    @FXML private Button crudEmployeesButton;
    @FXML private Button crudUsersButton;
    @FXML private Button finishRegisterBookButton;
    @FXML private TextField bookCreateTitleField;
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
    private TextField amoutToImport;

    @FXML
    private Button importBookButton;

    @FXML
    private Button finishBookEditButton;

    @FXML
    private TextField bookToEditTitle;

    @FXML
    private TextField bookToEditGenre;

    @FXML
    private TextField bookToEditAuthor;

    @FXML
    private TextField bookToEditPrice;

    @FXML
    private TextField bookToEditYear;

    @FXML
    private TextField bookToEditCode;

    @FXML
    private Button serachBookToEditButton;

    @FXML
    private TextField bookCodeToEdit;

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
    private TextField deleteEmployeeFieldName;

    @FXML
    private TextField deleteEmployeeFieldAge;

    @FXML
    private TextField deleteEmployeeFieldCode;

    @FXML
    private TextField deleteEmployeeFieldSalary;

    @FXML
    private Button deleteEmployeeSearchButton;

    @FXML
    private TextField deleteEmployeeFieldCodeToDelete;

    @FXML
    private Button editEmployeeButton;

    @FXML
    private TextField editEmployeeFieldName;

    @FXML
    private TextField editEmployeeFieldAge;

    @FXML
    private TextField editEmployeeFieldCode;

    @FXML
    private TextField editEmployeeFieldSalary;

    @FXML
    private Button editEmployeeSearchButton;

    @FXML
    private TextField editEmployeeCode;

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
    private TextField CreateUserField;

    @FXML
    private TextField CreatePasswordField;

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
    private Button serachUserToDeleteButton;

    @FXML
    private TextField codeUserToDeleteField;

    @FXML
    private TextField deleteUserField;

    @FXML
    private TextField deletePasswordField;

    @FXML
    private Tab codeUserToEditField;

    @FXML
    private Button saveChangesToEditButton;

    @FXML
    private TextField editUserEmployeeFieldName;

    @FXML
    private TextField editUserEmployeeFieldAge;

    @FXML
    private TextField editUserEmployeeFieldCode;

    @FXML
    private TextField editUserEmployeeFieldSalary;

    @FXML
    private Button serachUserToEditButton;

    @FXML
    private TextField editUserField;

    @FXML
    private TextField editPasswordField;

    private System s;
    private AdmFacade admFacade = new AdmFacade();

    public void initialize() {
        this.s = System.getInstance();

    }

    @FXML
    public void itemCriarLivro(){
        Parent root = null, chield = null;
        Scene scene = null;
        try {
            root = FXMLLoader.load(getClass().getResource("teste.fxml"));
            chield = FXMLLoader.load(getClass().getResource("CadastroLivro.fxml"));

            chield.setVisible(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*bookCreateTitleField;

    @FXML
    private TextField bookCreateGenreField;

    @FXML
    private TextField bookCreateAuthorField;

    @FXML
    private TextField bookCreatePriceField;

    @FXML
    private TextField bookCreateYearField;

    @FXML
    private TextField bookCreateCodeField;*/

    void registerBook() {
        Book aux = new Book();
        aux.setTitle(this.bookCreateTitleField.getText());
        aux.setAuthors(this.bookCreateAuthorField.getText());
        aux.setGenre(this.bookCreateGenreField.getText());
        aux.setCode(this.bookCreateCodeField.getText());
        String year = this.bookCreateYearField.getText();
        aux.setYear(Integer.parseInt(year));
        aux.setAmountAvailable(0);
        String price = this.bookCreatePriceField.getText();
        aux.setUnitPrice(Double.parseDouble(price));



    }




}

