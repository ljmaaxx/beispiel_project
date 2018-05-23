package model;

import model.beans.Book;

import java.util.ArrayList;

public class BookRepository {
    private ArrayList<Book> books;

    public BookRepository() {
        this.books = new ArrayList<Book>();
    }

    public void create(Book b) {
        this.books.add(b);
    }

    public ArrayList<Book> read() {
        return this.books;
    }

    public void update(Book oldBook, Book newBook) {
        this.books.remove(oldBook);
        this.books.add(newBook);
    }

    public void delete(Book b) {
        this.books.remove(b);
    }
}
