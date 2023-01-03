package bazi.finki.ukim.mk.finkiforums.Exceptions;

public class BadUsernameException extends RuntimeException{
    public BadUsernameException(String username) {
        super(String.format("User with username %s not found", username));
    }
}
