package bazi.finki.ukim.mk.finkiforums.Exceptions;

import bazi.finki.ukim.mk.finkiforums.Enumerations.UserType;

public class InvalidUserTypeException extends RuntimeException {
    public InvalidUserTypeException(UserType userType) {
        super(String.format("User with userType %s cannot be created with the registration form",userType.name()));
    }
}