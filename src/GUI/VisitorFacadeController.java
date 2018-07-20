package GUI;

import business.AdmFacade;
import business.beans.Book;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class VisitorFacadeController {

    @FXML
    private Button searchButton;

    @FXML
    private TextField searchValue;

    @FXML
    private TableView<Book> listBooksTable;

    @FXML
    private TableColumn<Book, String> title;

    @FXML
    private TableColumn<Book, String> author;

    @FXML
    private TableColumn<Book, String> year;

    @FXML
    private TableColumn<Book, String> genre;

    @FXML
    private TableColumn<Book, String> unitPrice;

    @FXML
    private TableColumn<Book, String> amountAvailable;

    @FXML
    private TableColumn<Book, String> code;

    private ObservableList<Book> data;

    private AdmFacade adm = new AdmFacade();
    private System s;
    private ArrayList<Book> searchBooks;

    public void initialize(){
        this.s = System.getInstance();

        this.searchButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                loadBooksListFacade(searchValue.getText());
            }
        });
    }

    void loadBooksListFacade(String value) {
        this.searchBooks = adm.searchBook(value);
        data = FXCollections.observableArrayList(adm.searchBook(value));

        this.title.setCellValueFactory(new PropertyValueFactory<>("title"));
        this.author.setCellValueFactory(new PropertyValueFactory<>("authors"));
        this.year.setCellValueFactory(new PropertyValueFactory<>("year"));
        this.genre.setCellValueFactory(new PropertyValueFactory<>("genre"));
        this.unitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        this.amountAvailable.setCellValueFactory(new PropertyValueFactory<>("amountAvailable"));
        this.code.setCellValueFactory(new PropertyValueFactory<>("code"));

        listBooksTable.setItems(data);
        data = FXCollections.observableArrayList(adm.readBooks());
    }
}