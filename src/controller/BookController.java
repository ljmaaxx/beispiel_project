package controller;

import model.BookRepository;
import model.beans.Book;

import java.util.ArrayList;

public class BookController {
    private BookRepository repository;

    public BookController() {
        this.repository = new BookRepository();
    }

    public BookRepository getRepository() {
        return repository;
    }

    public void createBook(Book b) {
        this.repository.create(b);
    }

    public ArrayList<Book> read() {
        return this.repository.read();
    }

    public void updateBook(Book oldBook, Book newBook) {
        this.repository.update(oldBook, newBook);
    }


    public Book searchBook(String title) {
        for (int i = 0; i < this.repository.read().size(); ++i) {
            if (this.repository.read().get(i).getTitle().equals(title)) {
                return this.repository.read().get(i);
            }
        }
        return null;
    }

    public void importBook(int amount, Book bookImported) {
        bookImported.increaseAmountAvailable(amount);
    }
}