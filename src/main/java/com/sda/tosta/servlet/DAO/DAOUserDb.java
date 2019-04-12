package com.sda.tosta.servlet.DAO;

import com.sda.tosta.servlet.User.Roles;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.*;

public class DAOUserDb {
    private static DAOUserDb instance;
    private List<User> userList;

    private DAOUserDb() {
        userList = new ArrayList<>();
        String password = "admin";
        String sha256hex = DigestUtils.sha256Hex(password);
        userList.add(new User("admin", sha256hex, "admin@admin.com",
                Arrays.asList(Roles.ADMIN, Roles.BASIC_USER)));
    }

    public static DAOUserDb getInstance() {
        if (instance == null) {
            instance = new DAOUserDb();
        }
        return instance;
    }

    public Optional<User> findByEmail(String email) {
        for (User user : userList) {
            if (user.getEmail().equals(email)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    public Optional<User> findByLogin(String login) {
        for (User user : userList) {
            if (user.getLogin().equals(login)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    public Optional<User> findByLoginAndPassword(String login, String password) {
        return userList.stream()
                .filter(x -> x.getLogin().equalsIgnoreCase(login))
                .filter(x -> x.getPassword().equals(password))
                .findFirst();
    }

    public List<User> getUserList() {
        return userList;
    }

    public Optional<User> getUserByLogin(String login) {
        return userList.stream()
                .filter(x -> x.getLogin().equals(login))
                .findFirst();
    }

    public User createNewUser(String login, String password, String email, List<Roles> roles) {
        String sha256hex = DigestUtils.sha256Hex(password);
        User user = new User(login, sha256hex, email, Collections.singletonList(Roles.BASIC_USER));
        userList.add(user);
        return user;
    }

}
