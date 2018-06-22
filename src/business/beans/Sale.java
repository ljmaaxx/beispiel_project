package business.beans;

import business.BookOnPurchase;

import java.util.ArrayList;

public class Sale {
    private ArrayList<BookOnPurchase> booksOnShoppingCart;
    private double totalPrice = 0;

    public Sale(ArrayList<BookOnPurchase> booksOnShoppingCart, double totalPrice) {
        this.booksOnShoppingCart = booksOnShoppingCart;
        this.totalPrice = totalPrice;
    }

    public Sale() {
        this.booksOnShoppingCart = new ArrayList<>();
    }

    public ArrayList<BookOnPurchase> getBooksOnShoppingCart() {
        return booksOnShoppingCart;
    }

    public void setBooksOnShoppingCart(ArrayList<BookOnPurchase> booksOnShoppingCart) {
        this.booksOnShoppingCart = booksOnShoppingCart;
    }

    public void addProductToSale(BookOnPurchase b, int amount) {
        if (b.getBookToBeBought().getAmountAvailable() <= amount) {
            this.booksOnShoppingCart.add(b);
            for (int i = 0; i < booksOnShoppingCart.size(); ++i) {
                if (this.booksOnShoppingCart.get(i).equals(b)) {
                    this.booksOnShoppingCart.get(i).setAmount(amount);
                }
            }
        }

    }

    public void removeProductOfSale(Book b) {
        this.booksOnShoppingCart.remove(b);
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getTotalPrice() {
        for (int i = 0; i < booksOnShoppingCart.size(); ++i) {
            this.totalPrice += this.booksOnShoppingCart.get(i).getBookToBeBought().getUnitPrice() *
                    this.booksOnShoppingCart.get(i).getAmount();
        }
        return totalPrice;
    }

    public void sale() {
        for (int i = 0; i < booksOnShoppingCart.size(); ++i) {
            this.booksOnShoppingCart.get(i).getBookToBeBought().decreaseAmountAvailable
                    (this.booksOnShoppingCart.get(i).getAmount());
        }
    }
}
