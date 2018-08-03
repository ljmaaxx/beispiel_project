package exceptions;

public class InexistentUserException extends Exception {
    @Override
    public String getMessage(){
        return "Este usuário não está cadastrado no sistema.";
    }
}
