package business;

import negocios.beans.Book;

import java.util.List;

public class FachadaVisitante {

    private UserController userController;
    private BookController bookController;

    public FachadaVisitante() {
        this.userController = new UserController();
        this.bookController = new BookController();
    }

    public List<Book> searchBook(Book b) {
        return bookController.searchBook(b);
    }




}
