package business;

import business.beans.User;
import data.IRepository;
import data.UserRepository;

import java.util.List;

public class UserController {

    private IRepository userRepository;

    public UserController() {
        this.userRepository = UserRepository.getInstance();
    }

    public void saveUser(){
        //TODO pesquisar se o usuario existe antes de inserir um novo
    }

    public User searchByUser(String username){
        User temp = null;
        for(User u : (List<User>)this.userRepository.read()){
            if(u.getUsername().equals(username)){
                temp = u;
                break;
            }
        }
        return temp;
    }

    public boolean existsUser(String username){
        return this.userRepository.exist(new User(username));
    }

    public boolean login(User user){
        if(existsUser(user.getUsername())){
            User search = searchByUser(user.getUsername());
            if(search != null){
                if(search.getPassword().equals(user.getPassword())){
                    //TODO aqui eu retorno true, ou seja, sucesso no login
                }else{
                    //TODO aqui eu retorno exceção pq a senha não é a mesma
                }
            }
        }else{
            return false;
            //TODO execeção usuario não existe ou não cadastrado
        }
        return false;
    }

}
