package exceptions;

public class PasswordMismatchException extends Exception {
    @Override
    public String getMessage(){
        return "Esta senha não corresponde a este usuário.";
    }
}
