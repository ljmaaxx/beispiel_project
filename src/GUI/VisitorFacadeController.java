package GUI;

import business.AdmFacade;
import business.beans.Book;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class VisitorFacadeController {

    @FXML
    private Button searchButton;

    @FXML
    private TextField searchValue;

    @FXML
    void initialize(ActionEvent event) {

    }

    private AdmFacade adm = new AdmFacade();
    private System s;
    private ArrayList<Book> searchBooks;

    public void initialize(){
        this.s = System.getInstance();

        this.searchButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                loadBooks(searchButton.getText());
            }
        });
    }

    void loadBooks(String value) {
        this.searchBooks = adm.searchBook(value);

    }
    /*data = FXCollections.observableArrayList(adm.readBooks());

        title = new TableColumn<>("Título");
        author = new TableColumn<>("Autor");
        year = new TableColumn<>("Ano");
        genre = new TableColumn<>("Gênero");
        unitPrice = new TableColumn<>("Preço");
        amountAvailable = new TableColumn<>("Qtd. Disponível");

        listBooksTable.getColumns().addAll(title, author, year, genre, unitPrice, amountAvailable);

        this.title.setCellValueFactory(new PropertyValueFactory<>("title"));
        this.author.setCellValueFactory(new PropertyValueFactory<>("author"));
        this.year.setCellValueFactory(new PropertyValueFactory<>("year"));
        this.genre.setCellValueFactory(new PropertyValueFactory<>("genre"));
        this.unitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        this.amountAvailable.setCellValueFactory(new PropertyValueFactory<>("amountAvailable"));

        listBooksTable.setItems(data);*/
}