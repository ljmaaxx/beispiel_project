package model.beans;

import model.beans.Book;
import model.beans.Client;

public class Sale {
    private int amountOfProducts;
    private Book product;
    private double totalPrice;
    private Client buyer;

    public Sale(int amountOfProducts, Book product, double totalPrice, Client buyer) {
        this.amountOfProducts = amountOfProducts;
        this.product = product;
        this.totalPrice = totalPrice;
        this.buyer = buyer;
    }

    public int getAmountOfProducts() {
        return amountOfProducts;
    }

    public void setAmountOfProducts(int amountOfProducts) {
        this.amountOfProducts = amountOfProducts;
    }

    public Book getProduct() {
        return product;
    }

    public void setProduct(Book product) {
        this.product = product;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
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
