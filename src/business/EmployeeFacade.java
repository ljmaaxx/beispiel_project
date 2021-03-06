package business;

import business.beans.Book;
import business.beans.Sale;
import java.util.ArrayList;
import java.util.List;

public class EmployeeFacade {
    private SaleController saleController;
    private BookController bookController;

    public EmployeeFacade() {
        this.saleController = new SaleController();
        this.bookController = new BookController();
    }

    public void create(Sale obj) {
        saleController.create(obj);
    }

    public List<Sale> read() {
        return saleController.read();
    }

    public void update(Sale oldObj, Sale newObj) {
        saleController.update(oldObj, newObj);
    }

    public void delete(Sale obj) {
        saleController.delete(obj);
    }

    public boolean exist(Sale obj) {
        return saleController.exist(obj);
    }

    public void sale(Book b) {
        saleController.sale(b);
    }

    public Sale search(String obj) {
        return saleController.search(obj);
    }

    public ArrayList<Book> searchBook(String value) {
        return bookController.search(value);

    }
}
