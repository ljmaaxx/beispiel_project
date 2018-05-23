package model;

import model.beans.Book;

public class BookRegister {
    private BookRepository repository;

    public BookRegister() {
        this.repository = new BookRepository();
    }

    public BookRepository getRepository() {
        return repository;
    }

    public void registerBook(Book b) {
        this.repository.create(b);
    }

    public void removeBook(Book b) {
        this.repository.delete(b);
    }

    public Book searchBook(String title) {
        for (int i = 0; i < this.repository.read().size(); ++i) {
            if (this.repository.read().get(i).getTitle().equals(title))
            {
                return this.repository.read().get(i);
            }
        }
        return null;
    }
}


