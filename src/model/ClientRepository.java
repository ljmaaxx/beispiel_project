package model;

import model.beans.Client;

import java.util.ArrayList;

public class ClientRepository {
    private ArrayList<Client> clients;

    public ClientRepository() {
        this.clients = new ArrayList<Client>();
    }

    public void create(Client c) {
        this.clients.add(c);
    }

    public ArrayList<Client> read() {
        return this.clients;
    }

    public void update(Client oldClient, Client newClient) {
        this.clients.remove(oldClient);
        this.clients.add(newClient);
    }

    public void delete(Client c) {
        this.clients.remove(c);
    }
}
