package data;

import business.beans.Sale;
import java.util.ArrayList;
import java.util.List;

public class SaleRepository implements IRepository<Sale> {
    private ArrayList<Sale> sales;
    private static SaleRepository instance;

    private SaleRepository() {
        this.sales = new ArrayList<>();
    }

    public static SaleRepository getInstance() {
        if (instance == null) {
            instance = new SaleRepository();
        }
        return instance;
    }

    @Override
    public void create(Sale obj) {
        this.sales.add(obj);
    }

    @Override
    public List<Sale> read() {
        return this.sales;
    }

    @Override
    public void update(Sale oldObj, Sale newObj) {
        this.sales.add(newObj);
        this.sales.remove(oldObj);
    }

    @Override
    public void delete(Sale obj) {
        this.sales.remove(obj);
    }

    public boolean exist(Sale s) {
        return this.sales.contains(s);
    }

    @Override
    public Sale search(String obj) {
        for (int i = 0; i < this.sales.size(); ++i) {
            if (this.sales.get(i).getBooksOnShoppingCart().get(i).getBookToBeBought().getTitle().equals(sales)) {
                return this.sales.get(i);
            }
        }
        return null;
    }
}