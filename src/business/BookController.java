package business;


import business.beans.Book;
import data.BookRepository;
import data.IRepository;
import exceptions.BookDoesntExistException;

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

    public ArrayList<Book> searchBook(String value) throws BookDoesntExistException {
        ArrayList<Book> booksToReturn = (ArrayList) this.repositoryBooks.read();
        ArrayList<Book> matchBooks = new ArrayList<>();

        if (true) {
            for (int i = 0; i < booksToReturn.size(); ++i) {
                String title = booksToReturn.get(i).getTitle();
                if (value.equals(title)) {
                    matchBooks.add(booksToReturn.get(i));
                }
            }

            for (int i = 0; i < booksToReturn.size(); ++i) {
                String author = booksToReturn.get(i).getAuthors();
                if (value.equals(author)) {
                    matchBooks.add(booksToReturn.get(i));
                }
            }

            for (int i = 0; i < booksToReturn.size(); ++i) {
                String title = booksToReturn.get(i).getTitle();
                if (value.equals(title)) {
                    matchBooks.add(booksToReturn.get(i));
                }
            }

            for (int i = 0; i < booksToReturn.size(); ++i) {
                String code = booksToReturn.get(i).getCode();
                if (value.equals(code)) {
                    matchBooks.add(booksToReturn.get(i));
                }
            }

            for (int i = 0; i < booksToReturn.size(); ++i) {
                String genre = booksToReturn.get(i).getGenre();
                if (value.equals(genre)) {
                    matchBooks.add(booksToReturn.get(i));
                }
            }
        }
        else {
            throw new BookDoesntExistException();
        }
        return matchBooks;
    }

    public void importBook(int amount, Book bookImported) {
        bookImported.increaseAmountAvailable(amount);
    }

    public void delete(Book obj) {
        repositoryBooks.delete(obj);
    }
}