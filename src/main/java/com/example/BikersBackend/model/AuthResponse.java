package com.example.BikersBackend.model;

public class AuthResponse {
    int userId;
    boolean is_admin;

    public AuthResponse(int userId, boolean is_admin) {
        this.userId = userId;
        this.is_admin = is_admin;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public boolean getIs_admin() {
        return is_admin;
    }

    public void setIs_admin(boolean is_admin) {
        this.is_admin = is_admin;
    }
}
