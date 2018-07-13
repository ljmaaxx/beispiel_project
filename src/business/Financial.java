package business;

import business.beans.Book;
import business.beans.Sale;

public class Financial {
    private SaleController saleController;
    private Sale sale;

    //TODO implementar singleton
    public Financial() {
        this.saleController = new SaleController();
    }

    public void sale(Book b) {
        BookOnPurchase bop = new BookOnPurchase(b, 1);
        b.decreaseAmountAvailable(1);
        //this.sale.addProductToSale();



    }
}
