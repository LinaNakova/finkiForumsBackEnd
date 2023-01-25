package bazi.finki.ukim.mk.finkiforums.Exceptions;

public class InvalidCourseIdException extends RuntimeException{
    public InvalidCourseIdException(Long id) {
        super(String.format("Course with id %d doesn't exist", id));
    }
}
