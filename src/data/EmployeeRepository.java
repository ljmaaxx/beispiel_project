package data;

import business.beans.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IRepository<Employee>, Serializable {
    private ArrayList<Employee> employees;
    private static EmployeeRepository instance;

    private EmployeeRepository() {
        this.employees = new ArrayList<Employee>();
    }

    public static EmployeeRepository getInstance() {
        if (instance == null) {
            instance = readArchive();
        }
        return instance;
    }

    @Override
    public void create(Employee obj) {
        this.employees.add(obj);
        saveArchive();
    }

    @Override
    public ArrayList<Employee> read() {
        return this.employees;
    }

    @Override
    public void update(Employee oldObj, Employee newObj) {
        this.employees.add(newObj);
        this.employees.remove(oldObj);
        saveArchive();
    }

    @Override
    public void delete(Employee obj) {
        this.employees.remove(obj);
        saveArchive();
    }

    public boolean exist(Employee e) {
        return this.employees.contains(e);
    }

    @Override
    public ArrayList<Employee> search(String obj) {
        return null;
    }

    public Employee searchEmployee(String text) {
        for (int i = 0; i < this.employees.size(); ++i) {
            if (this.employees.get(i).getName().equals(text)) {
                return this.employees.get(i);
            }
            else if (this.employees.get(i).getIdCode().equals(text)) {
                return this.employees.get(i);
            }
        }
        return null;
    }

    private static EmployeeRepository readArchive() {
        EmployeeRepository localInstance;

        File in = new File("Data.txt");
        FileInputStream fis;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(in);
            ois = new ObjectInputStream(fis);
            Object o = ois.readObject();
            localInstance = (EmployeeRepository) o;
        } catch (Exception e) {
            localInstance = new EmployeeRepository();
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
