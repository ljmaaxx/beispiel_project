package GUI;

import business.AdmFacade;
import business.beans.Book;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;

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

    private AdmFacade adm = new AdmFacade();

    public void initialize(){
        this.searchButton.setOnAction(event -> loadBooksListFacade(searchValue.getText()));
        this.searchValue.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                loadBooksListFacade(searchValue.getText());
            }
        });
    }

    private void loadBooksListFacade(String value) {
        ObservableList<Book> data = FXCollections.observableArrayList(adm.searchBook(value));
        this.title.setCellValueFactory(new PropertyValueFactory<>("title"));
        this.author.setCellValueFactory(new PropertyValueFactory<>("authors"));
        this.year.setCellValueFactory(new PropertyValueFactory<>("year"));
        this.genre.setCellValueFactory(new PropertyValueFactory<>("genre"));
        this.unitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        this.amountAvailable.setCellValueFactory(new PropertyValueFactory<>("amountAvailable"));
        this.code.setCellValueFactory(new PropertyValueFactory<>("code"));
        listBooksTable.setItems(data);
    }
}