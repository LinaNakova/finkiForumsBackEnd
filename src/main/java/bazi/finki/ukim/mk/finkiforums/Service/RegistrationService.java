package bazi.finki.ukim.mk.finkiforums.Service;

import bazi.finki.ukim.mk.finkiforums.Enumerations.UserType;
import bazi.finki.ukim.mk.finkiforums.Response.UserResponse;

public interface RegistrationService {
    UserResponse create(String name, String lastName, String email, String username, String password, UserType userType, String index);
}
