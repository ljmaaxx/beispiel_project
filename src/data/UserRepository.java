package data;


import business.beans.User;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IRepository<User> {
    private static UserRepository instance;
    private ArrayList<User> users;

    public static UserRepository getInstance() {
        if(instance == null){
            instance = new UserRepository();
        }
        return instance;
    }

    private UserRepository() {
        this.users = new ArrayList<>();
    }

    @Override
    public void create(User obj) {
        this.users.add(obj);
    }

    @Override
    public List<User> read() {
        return this.users;
    }

    @Override
    public void update(User oldObj, User newObj) {
        this.users.add(newObj);
        this.users.remove(oldObj);
    }

    @Override
    public void delete(User obj) {
        this.users.remove(obj);
    }

    @Override
    public boolean exist(User obj) {
        return this.users.contains(obj);
    }

    @Override
    public User search(String obj) {
        return null;
    }


}
