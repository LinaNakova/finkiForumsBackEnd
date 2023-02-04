package bazi.finki.ukim.mk.finkiforums.Exceptions;

public class InvalidCategoryIdException extends RuntimeException{
    public InvalidCategoryIdException(Long id) {
        super(String.format("Category with id %d doesn't exist", id));
    }
}
