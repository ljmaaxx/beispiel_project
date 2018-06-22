package data;

import negocios.beans.Sale;

import java.util.ArrayList;
import java.util.List;

public class SaleRepository implements IRepository<Sale> {
    private ArrayList<Sale> sales;

    public SaleRepository() {
        this.sales = new ArrayList<>();
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
        if (this.sales.contains(s)) return true;
        return false;
    }
}
