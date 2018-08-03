package business;


import business.beans.Book;
import data.BookRepository;
import data.IRepository;
import java.util.ArrayList;
import java.util.List;

public class BookController {
    private IRepository repositoryBooks;

    public BookController() {
        this.repositoryBooks = BookRepository.getInstance();
    }

    public void createBook(Book b) {
        this.repositoryBooks.create(b);
    }

    public List<Book> read() {
        return this.repositoryBooks.read();
    }

    public void updateBook(Book oldBook, Book newBook) {
        this.repositoryBooks.update(oldBook, newBook);
    }

    public void importBook(int amount, Book bookImported) {
        bookImported.increaseAmountAvailable(amount);
    }

    public ArrayList<Book> search(String text) {
        return this.repositoryBooks.search(text);
    }

    public void delete(Book obj) {
        repositoryBooks.delete(obj);
    }
}