package bazi.finki.ukim.mk.finkiforums.Service;

import bazi.finki.ukim.mk.finkiforums.Response.UserResponse;

public interface LoginService {
    UserResponse findUserByUsername(String username, String password);
    String getActiveProfessorUsername();
}
