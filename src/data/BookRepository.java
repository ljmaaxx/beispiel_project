package data;

import business.beans.Book;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BookRepository implements IRepository<Book>, Serializable {
    private ArrayList<Book> books;
    private static BookRepository instance;

    private BookRepository() {
        this.books = new ArrayList<>();
    }

    public static BookRepository getInstance() {
        if (instance == null) {
            instance = readArchive();
        }
        return instance;
    }

    @Override
    public void create(Book obj) {
        this.books.add(obj);
        saveArchive();
    }

    @Override
    public List<Book> read() {
        return this.books;
    }

    @Override
    public void update(Book oldObj, Book newObj) {
        this.books.add(newObj);
        this.books.remove(oldObj);
        saveArchive();
    }

    @Override
    public void delete(Book obj) {
        this.books.remove(obj);
        saveArchive();
    }

    public boolean exist(Book b) {
        return this.books.contains(b);
    }

    @Override
    public ArrayList<Book> search(String value) {
        ArrayList<Book> matchBooks = new ArrayList<>();

        if (true) {
            for (int i = 0; i < books.size(); ++i) {
                String title = books.get(i).getTitle();
                if (value.equalsIgnoreCase(title)) {
                    matchBooks.add(books.get(i));
                }
            }

            for (int i = 0; i < books.size(); ++i) {
                String author = books.get(i).getAuthors();
                if (value.equalsIgnoreCase(author)) {
                    matchBooks.add(books.get(i));
                }
            }

            for (int i = 0; i < books.size(); ++i) {
                String title = books.get(i).getTitle();
                if (value.equalsIgnoreCase(title)) {
                    matchBooks.add(books.get(i));
                }
            }

            for (int i = 0; i < books.size(); ++i) {
                String code = books.get(i).getCode();
                if (value.equalsIgnoreCase(code)) {
                    matchBooks.add(books.get(i));
                }
            }

            for (int i = 0; i < books.size(); ++i) {
                String genre = books.get(i).getGenre();
                if (value.equalsIgnoreCase(genre)) {
                    matchBooks.add(books.get(i));
                }
            }
        }
        return matchBooks;
    }


    private static BookRepository readArchive() {
        BookRepository localInstance;

        File in = new File("Data.txt");
        FileInputStream fis;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(in);
            ois = new ObjectInputStream(fis);
            Object o = ois.readObject();
            localInstance = (BookRepository) o;
        } catch (Exception e) {
            localInstance = new BookRepository();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {}
            }
        }
        return localInstance;
    }

    public void saveArchive() {
        if (instance == null) {
            return;
        }
        File out = new File("Data.txt");
        FileOutputStream fos;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(out);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(instance);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {}
            }
        }
    }
}
