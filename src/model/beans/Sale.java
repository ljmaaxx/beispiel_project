package model.beans;

import java.util.ArrayList;

public class Sale {
    private ArrayList<Book> books;
    private Client buyer;

    public Sale(ArrayList<Book> products, Client buyer) {
        this.books = products;
        this.buyer = buyer;
    }

    public Sale() {
        this.books = new ArrayList<>();
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public void addProductToSale(Book b) {
        this.books.add(b);
    }

    public void removeProductOfSale(Book b) {
        this.books.remove(b);
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (int i = 0; i < books.size(); ++i) {
            totalPrice += books.get(i).getUnitPrice();
        }
        return totalPrice;
    }

    public Client getBuyer() {
        return buyer;
    }

    public void setBuyer(Client buyer) {
        this.buyer = buyer;
    }

    public void export() {

    }

    public void sale() {

    }
}
