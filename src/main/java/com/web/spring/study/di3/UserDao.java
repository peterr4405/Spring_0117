package com.web.spring.study.di3;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserDao {

    @Value("#{${users : {{'username': 'admin', 'password': '1234'}, {'username': 'john', 'password': '5678'}}}}")
    private List<Map<String, String>> users;

    public List<Map<String, String>> getUsers() {
        return users;
    }

    public void setUsers(List<Map<String, String>> users) {
        this.users = users;
    }

    public Map<String, String> get(String username) {
        return users.stream().filter(u -> u.get("username").equals(username)).findFirst().get();
    }

    public void addUser(String username, String password) {
        Map<String, String> user = new LinkedHashMap<>();
        user.put("username", username);
        user.put("password", password);
        users.add(user);
    }

    public void updatePassword(String username, String newPass) {
        Map<String, String> user = get(username);
        if (user == null) {
            return;
        }
        delUser(username);
        user = new LinkedHashMap<>();
        user.put("username", username);
        user.put("password", newPass);
        users.add(user);
    }

    public void delUser(String username) {
        Map<String, String> user = get(username);
        if (user == null) {
            return;
        }
        users.remove(user);

    }

    @Override
    public String toString() {
        return "UserDao{" + "users=" + users + '}';
    }

}
