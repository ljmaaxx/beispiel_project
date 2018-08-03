package business;

import business.beans.User;
import data.IRepository;
import data.UserRepository;
import exceptions.InexistentUserException;
import exceptions.PasswordMismatchException;
import exceptions.UserAlreadyRegisteredException;

import java.util.List;

public class UserController {

    private IRepository<User> userRepository;

    UserController() {
        this.userRepository = UserRepository.getInstance();
    }

    void saveUser(User user) throws UserAlreadyRegisteredException {
        try {
            if (this.searchByUser(user.getUsername()) == null) {
                this.userRepository.create(user);
            }
            else {
                throw new UserAlreadyRegisteredException();
            }
        } catch (InexistentUserException e) {
            e.printStackTrace();
        }
    }

    User searchByUser(String username) throws InexistentUserException{
        if (username != null) {
            for(User u : this.userRepository.read()){
                if(u.getUsername().equals(username)){
                    return u;
                }
            }
        }
        else {
            throw new InexistentUserException();
        }
        return null;
    }

    boolean existsUser(String username){
        return this.userRepository.exist(new User(username));
    }

    boolean login(User user) throws PasswordMismatchException, InexistentUserException {
        if(existsUser(user.getUsername())){
            User search = null;
            try {
                search = searchByUser(user.getUsername());
            } catch (InexistentUserException e) {
                e.printStackTrace();
            }
            if(search != null){
                if(search.getPassword().equals(user.getPassword())){
                    return true;
                } else {
                    throw new PasswordMismatchException();
                }
            }
        }
        else {
            throw new InexistentUserException();
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
}
