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

    public void saveUser(User user){
        if (this.searchByUser(user.getUsername()) == null) {
            this.userRepository.create(user);
        }
        else {
            //TODO throw new usuarionaocadastradado exception?
        }
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
                    return true;
                }else{
                    //TODO aqui eu retorno exceção pq a senha não é a mesma
                }
            }
        }
        else {
            return false;
            //TODO execeção usuario não existe ou não cadastrado
        }
        return false;
    }

    public List<User> read() {
        return userRepository.read();
    }

    public void update(User oldObj, User newObj) {
        userRepository.update(oldObj, newObj);
    }

    public void delete(User obj) {
        userRepository.delete(obj);
    }

    public boolean exist(User obj) {
        return userRepository.exist(obj);
    }

    public User search(String obj) {
        return (User) userRepository.search(obj);
    }
}
