package business;

import business.beans.Book;

import java.util.List;

public class VisitorFacade {

    private UserController userController;
    private BookController bookController;

    public VisitorFacade() {
        this.userController = new UserController();
        this.bookController = new BookController();
    }

    public List<Book> searchBook(Book b) {
        return bookController.searchBook(b);
    }




}
