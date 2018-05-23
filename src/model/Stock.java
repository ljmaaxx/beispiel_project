package model;

import model.beans.Book;

import java.util.ArrayList;

public class Stock {
    private Product product;
    private ArrayList<Product> products;


    public void addToStock(Product p) {
        this.products.add(p);
    }

    public void removeFromStock(Product p) {
        this.products.remove(p);
    }

    public void importProduct(Product p, int amountOfBoxes) {
        if(this.products.contains(p)) {
            p.increaseAmount(amountOfBoxes);
        }
        else {
            this.products.add(p);
            p.increaseAmount(amountOfBoxes);
        }
    }

    public Product searchProduct(String productName) {
        for (int i = 0; i < this.products.size(); ++i) {
            if (this.products.get(i).getProductName().equals(productName)) {
                return this.products.get(i);
            }
        }
        return null;
    }

}
