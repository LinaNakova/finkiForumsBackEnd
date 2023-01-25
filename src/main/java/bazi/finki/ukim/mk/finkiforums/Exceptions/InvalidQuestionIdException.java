package bazi.finki.ukim.mk.finkiforums.Exceptions;

public class InvalidQuestionIdException extends RuntimeException{
    public InvalidQuestionIdException(Long id) {
        super(String.format("Question with id %d doesn't exist", id));
    }
}