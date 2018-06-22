package data;

import business.beans.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientRepository implements IRepository<Client> {
    private ArrayList<Client> clients;
    private static ClientRepository instance;

    private ClientRepository() {
        this.clients = new ArrayList<Client>();
    }

    public static ClientRepository getInstance() {
        if (instance == null) {
            instance = new ClientRepository();
        }
        return instance;
    }

    @Override
    public void create(Client obj) {
        this.clients.add(obj);
    }

    @Override
    public List<Client> read() {
        return this.clients;
    }

    @Override
    public void update(Client oldObj, Client newObj) {
        this.clients.add(newObj);
        this.clients.remove(oldObj);
    }

    @Override
    public void delete(Client obj) {
        this.clients.remove(obj);
    }

    public boolean exist(Client c) {
        return this.clients.contains(c);
    }
}
