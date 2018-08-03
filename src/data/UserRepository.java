package data;

import business.beans.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IRepository<User>, Serializable {
    private static UserRepository instance;
    private ArrayList<User> users;

    public static UserRepository getInstance() {
        if(instance == null){
            instance = readArchive();
        }
        return instance;
    }

    private UserRepository() {
        this.users = new ArrayList<>();
    }

    @Override
    public void create(User obj) {
        this.users.add(obj);
        saveArchive();
    }

    @Override
    public List<User> read() {
        return this.users;
    }

    @Override
    public void update(User oldObj, User newObj) {
        this.users.add(newObj);
        this.users.remove(oldObj);
        saveArchive();
    }

    @Override
    public void delete(User obj) {
        this.users.remove(obj);
        saveArchive();
    }

    @Override
    public boolean exist(User obj) {
        return this.users.contains(obj);
    }

    @Override
    public ArrayList<User> search(String obj) {
        return null;
    }

    private static UserRepository readArchive() {
        UserRepository localInstance;

        File in = new File("Data.txt");
        FileInputStream fis;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(in);
            ois = new ObjectInputStream(fis);
            Object o = ois.readObject();
            localInstance = (UserRepository) o;
        } catch (Exception e) {
            localInstance = new UserRepository();
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
