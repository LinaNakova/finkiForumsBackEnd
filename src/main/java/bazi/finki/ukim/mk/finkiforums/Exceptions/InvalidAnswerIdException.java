package bazi.finki.ukim.mk.finkiforums.Exceptions;

public class InvalidAnswerIdException extends RuntimeException{
    public InvalidAnswerIdException(Long id) {
        super(String.format("Answer with id %d doesn't exist", id));
    }
}
