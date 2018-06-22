package business;

import business.beans.Sale;
import data.IRepository;
import data.SaleRepository;

import java.util.List;

public class SaleController {
    private IRepository saleRepository;
    private Sale sales;

    public SaleController() {
        this.saleRepository = SaleRepository.getInstance();
    }

    public void create(Sale obj) {
        saleRepository.create(obj);
    }

    public List<Sale> read() {
        return saleRepository.read();
    }

    public void update(Sale oldObj, Sale newObj) {
        saleRepository.update(oldObj, newObj);
    }

    public void delete(Sale obj) {
        saleRepository.delete(obj);
    }

    public boolean exist(Sale obj) {
        return saleRepository.exist(obj);
    }

    public void sale() {
        this.sales.sale();
    }

    public Sale search(String obj) {
        return (Sale) saleRepository.search(obj);
    }
}
