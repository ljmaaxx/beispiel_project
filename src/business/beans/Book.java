package business.beans;

import java.io.Serializable;

public class Book implements Serializable {
    private String title;
    private String authors;
    private int year;
    private String genre;
    private String code;
    private double unitPrice;
    private int amountAvailable;

    public Book(String name, String authors, int year, String genre, String code, double unitPrice) {
        this.title = name;
        this.authors = authors;
        this.year = year;
        this.genre = genre;
        this.code = code;
        this.unitPrice = unitPrice;
        this.amountAvailable = 0;
    }

    public Book() { this.amountAvailable = 0; }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String name) {
        this.authors = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCode() {
        return code;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getAmountAvailable() {
        return amountAvailable;
    }

    public void setAmountAvailable(int amountAvailable) {
        this.amountAvailable = amountAvailable;
    }

    public void increaseAmountAvailable(int amount) {
        this.amountAvailable += amount;
    }

    public void decreaseAmountAvailable(int amount) {
        this.amountAvailable -= amount;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String toString() {
        String s = "Book informations:\n";
        s += "Title: " + this.getTitle();
        s += "\nAuthor: " + this.getAuthors();
        s += "\nYear: " + this.getYear();
        s += "\nGenre: " + this.getGenre();
        s += "\nUnit price: $" + this.getUnitPrice();
        s += "\nAmount Available: " + this.getAmountAvailable();
        return s;
    }

    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (obj instanceof Book) {
            Book b = (Book) obj;
            if(b.getCode().equals(this.getCode())) return true;
        }
        return false;
    }
}
