package exceptions;

public class UserAlreadyRegisteredException extends Exception {
    @Override
    public String getMessage(){
        return "Este usuário já possui cadastro.";
    }
}
