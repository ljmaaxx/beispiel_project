package business.beans;

public class Book {
    private String title;
    private Author author;
    private int year;
    private String genre;
    private String code;
    private double unitPrice;
    private int amountAvailable;

    public Book(String name, Author author, int year, String genre, String code, double unitPrice) {
        this.title = name;
        this.author = author;
        this.year = year;
        this.genre = genre;
        this.code = code;
        this.unitPrice = unitPrice;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
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

    public void setCode(String code) {
        this.code = code;
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

    public String toString() {
        String s = "Book informations:\n";
        s += "Title: " + this.getTitle();
        s += "\nAuthor: " + this.getAuthor();
        s += "\nYear: " + this.getYear();
        s += "\nGenre: " + this.getGenre();
        s += "\nUnit price: " + this.getUnitPrice();
        return s;
    }

    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (obj instanceof Book) {
            Book b = (Book) obj;
            if(b.getCode().equals(this.getCode()))
                return true;
        }
        return false;
    }

}
