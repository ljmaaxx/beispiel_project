package data;

import negocios.beans.Book;

import java.util.ArrayList;
import java.util.List;

public class BookRepository implements IRepository<Book> {
    private ArrayList<Book> books;
    private static BookRepository instance;

    private BookRepository() {
        this.books = new ArrayList<Book>();
    }

    public static BookRepository getInstance() {
        if (instance == null) {
            instance = new BookRepository();
        }
        return instance;
    }


    @Override
    public void create(Book obj) {
        this.books.add(obj);
    }

    @Override
    public List<Book> read() {
        return this.books;
    }

    @Override
    public void update(Book oldObj, Book newObj) {
        this.books.add(newObj);
        this.books.remove(oldObj);
    }

    @Override
    public void delete(Book obj) {
        this.books.remove(obj);

    }

    public boolean exist(Book b) {
        if (this.books.contains(b)) return true;
        return false;
    }
}
