package exceptions;

public class BookDoesntExistException extends Exception {
    @Override
    public String getMessage(){
        return "Este livro não está cadastrado no sistema.";
    }
}
