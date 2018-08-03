package business.beans;

import java.io.Serializable;

public class BookOnPurchase implements Serializable {
    private Book bookToBeBought;
    private int amount;

    public BookOnPurchase(Book bookToBeBought, int amount) {
        this.bookToBeBought = bookToBeBought;
        this.amount = amount;
    }

    public Book getBookToBeBought() {
        return bookToBeBought;
    }

    public void setBookToBeBought(Book bookToBeBought) {
        this.bookToBeBought = bookToBeBought;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
