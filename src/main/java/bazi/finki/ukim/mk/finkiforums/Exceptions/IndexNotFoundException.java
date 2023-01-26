package bazi.finki.ukim.mk.finkiforums.Exceptions;

public class IndexNotFoundException extends RuntimeException {
    public IndexNotFoundException() {
        super("Index not found");
    }
}
