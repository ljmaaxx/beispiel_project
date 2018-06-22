package data;

import negocios.beans.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientRepository implements IRepository<Client> {
    private ArrayList<Client> clients;

    public ClientRepository() {
        this.clients = new ArrayList<Client>();
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
        if (this.clients.contains(c)) return true;
        return false;
    }
}
