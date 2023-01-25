package bazi.finki.ukim.mk.finkiforums.Response;

import bazi.finki.ukim.mk.finkiforums.Enumerations.UserType;

public class UserResponse {
    public String username;
    public UserType userType;

    public UserResponse(String username, UserType userType) {
        this.username = username;
        this.userType = userType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
