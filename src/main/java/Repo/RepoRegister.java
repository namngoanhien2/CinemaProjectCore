package Repo;

import entity.User;
import security.JwtGenerator;

import java.util.ArrayList;
import java.util.List;

public class RepoRegister extends BaseRepo {
    public List<User> Register(int iduser, String username, String password, int role) {
        entityManager.getTransaction().begin();
        User user = new User();
        user.setIduser(iduser);
        user.setUsername(username);
        user.setPassword(password);
        user.setRole(role);
        String token = JwtGenerator.getInstance().generate(user);
        user.setToken(token);
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        List<User> list = new ArrayList<>();
        list.add(user);
        return list;
    }
}
