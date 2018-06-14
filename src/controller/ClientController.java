package controller;

import model.ClientRepository;
import model.beans.Client;

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

    public Client searchBook(String name) {
        if ((!this.repository.read().isEmpty()) && name != null)
        {
            for (int i = 0; i < this.repository.read().size(); ++i) {
                if (this.repository.read().get(i).getName().equals(name))
                {
                    return this.repository.read().get(i);
                }
            }
        }
        return null;
    }
}
