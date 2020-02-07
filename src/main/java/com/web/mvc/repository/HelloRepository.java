package com.web.mvc.repository;

import com.web.beans.User;
import java.util.List;
import java.util.Vector;
import java.util.stream.Stream;
import org.springframework.stereotype.Repository;

@Repository
public class HelloRepository {

    private static List<User> users = new Vector<>();

    public User getUser(Integer id) {
        return users.stream().filter(u -> u.getNum().getId().equals(id)).iterator().next();
    }

    public List<User> queryUsers() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void updateUser(Integer id, User user) {
        User u = users.get(id);
        if (u != null) {
            u.setName(user.getName());
            u.setAge(user.getAge());
        }
    }

    public void removeUser(Integer id) {
        User user = users.stream().filter(u -> u.getNum().getId().equals(id)).findFirst().get();
        //User user = getUser(id);
        if (user != null) {
            users.remove(user);
        }
    }

}
