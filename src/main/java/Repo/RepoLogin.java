package Repo;

import entity.User;

import javax.persistence.Query;
import java.util.List;

public class RepoLogin extends BaseRepo {

    public List<String> login(User user) {
        Query query = entityManager.createQuery("select u.iduser, u.password from User u");
        List<String> list = query.getResultList();
        return list;
    }

    public void updateToken(String token, int iduser) {
        User user = null;
        user = entityManager.find(User.class, iduser);
        entityManager.getTransaction().begin();
        user.setToken(token);
        entityManager.getTransaction().commit();
    }

    public List<String> ckeck(User user) {
        Query query = entityManager.createQuery("select u.token from User u");
        List<String> list = query.getResultList();
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }
}
