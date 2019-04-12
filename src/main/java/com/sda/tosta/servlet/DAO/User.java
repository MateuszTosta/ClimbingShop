package com.sda.tosta.servlet.DAO;

import com.sda.tosta.servlet.User.Roles;

import java.util.List;

public class User {
    private String login;
    private String password;
    private String email;
    private List<Roles> roles;

    public User(String login, String password, String email, List<Roles> roles) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.roles = roles;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Roles> getRoles() {
        return roles;
    }

    public void setRoles(List<Roles> roles) {
        this.roles = roles;
    }
}
