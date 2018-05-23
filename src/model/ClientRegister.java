package model;

import model.beans.Client;

public class ClientRegister {
    private ClientRepository repository;

    public ClientRegister() {
        this.repository = new ClientRepository();
    }

    public ClientRepository getRepository() {
        return repository;
    }

    public void setRepository(ClientRepository repository) {
        this.repository = repository;
    }

    public void registerClient(Client c) {
        this.repository.create(c);
    }

    public void removeClient(Client c) {
        this.repository.delete(c);
    }

    public Client searchClient(String name) {
        for (int i = 0; i < this.repository.read().size(); ++i) {
            if (this.repository.read().get(i).getName().equals(name))
            {
                return this.repository.read().get(i);
            }
        }
        return null;
    }
}
