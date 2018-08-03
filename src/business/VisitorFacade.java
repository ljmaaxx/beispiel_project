package business;

import business.beans.Book;
import java.util.ArrayList;
import java.util.List;

public class VisitorFacade {

    private BookController bookController;

    public VisitorFacade() {
        this.bookController = new BookController();
    }

    public List<Book> read() {
        return bookController.read();
    }

    public ArrayList<Book> search(String value) {
        return this.bookController.search(value);
    }
}
