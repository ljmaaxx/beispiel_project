package business;


import business.beans.Client;
import data.ClientRepository;

public class ClientController {
    private ClientRepository repository;

    public void registerClient(Client b) {
        if(b != null && (!this.repository.read().contains(b)))
            this.repository.create(b);
    }

    public void removeClient(Client c) {
        if (c != null && this.repository.read().contains(c))
            this.repository.delete(c);
    }
}
