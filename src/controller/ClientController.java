package controller;

import model.ClientRegister;
import model.beans.Client;

public class ClientController {
    private ClientRegister clientRegister;

    public void registerClient(Client b) {
        if(b != null && (!this.clientRegister.getRepository().read().contains(b)))
            this.clientRegister.getRepository().create(b);
    }

    public void removeClient(Client c) {
        if (c != null && this.clientRegister.getRepository().read().contains(c))
            this.clientRegister.getRepository().delete(c);
    }

    public Client searchBook(String name) {
        if ((!this.clientRegister.getRepository().read().isEmpty()) && name != null)
        {
            for (int i = 0; i < this.clientRegister.getRepository().read().size(); ++i) {
                if (this.clientRegister.getRepository().read().get(i).getName().equals(name))
                {
                    return this.clientRegister.getRepository().read().get(i);
                }
            }
        }
        return null;
    }
}
