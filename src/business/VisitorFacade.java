package business;

import business.beans.Book;

import java.util.List;

public class VisitorFacade {

    private BookController bookController;

    public VisitorFacade() {
        this.bookController = new BookController();
    }

    public List<Book> read() {
        return bookController.read();
    }

    public Book search(String title) {
        return this.bookController.searchBook(title);
    }
}
