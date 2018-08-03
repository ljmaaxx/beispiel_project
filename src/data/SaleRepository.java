package data;

import business.beans.Sale;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SaleRepository implements IRepository<Sale>, Serializable {
    private ArrayList<Sale> sales;
    private static SaleRepository instance;

    private SaleRepository() {
        this.sales = new ArrayList<>();
    }

    public static SaleRepository getInstance() {
        if (instance == null) {
            instance = readArchive();
        }
        return instance;
    }

    @Override
    public void create(Sale obj) {
        this.sales.add(obj);
        saveArchive();
    }

    @Override
    public List<Sale> read() {
        return this.sales;
    }

    @Override
    public void update(Sale oldObj, Sale newObj) {
        this.sales.add(newObj);
        this.sales.remove(oldObj);
        saveArchive();
    }

    @Override
    public void delete(Sale obj) {
        this.sales.remove(obj);
        saveArchive();
    }

    public boolean exist(Sale s) {
        return this.sales.contains(s);
    }

    @Override
    public ArrayList<Sale> search(String obj) {
        /*for (int i = 0; i < this.sales.size(); ++i) {
            if (this.sales.get(i).getBooksOnShoppingCart().get(i).getBookToBeBought().getTitle().equals(sales)) {
                return this.sales.get(i);
            }
        }*/
        return null;
    }

    private static SaleRepository readArchive() {
        SaleRepository localInstance;

        File in = new File("Data.txt");
        FileInputStream fis;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(in);
            ois = new ObjectInputStream(fis);
            Object o = ois.readObject();
            localInstance = (SaleRepository) o;
        } catch (Exception e) {
            localInstance = new SaleRepository();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {}
            }
        }
        return localInstance;
    }

    public void saveArchive() {
        if (instance == null) {
            return;
        }
        File out = new File("Data.txt");
        FileOutputStream fos;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(out);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(instance);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {}
            }
        }
    }
}