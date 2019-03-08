package Repo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Cinema;

import javax.persistence.Query;
import java.util.*;

public class RepoCinema extends BaseRepo {

    public String listAll() {
        String sql = "SELECT c.idcinema,c.name,c.address,c.quantily,c.khuvuc from Cinema c ";
        Query query = entityManager.createQuery(sql);
        List<Cinema> list = query.getResultList();
        if (list.isEmpty()) {
            return null;
        }
        ObjectMapper objectMapper = new ObjectMapper();
        String json = null;
        try {
            json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(list);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }

    public String findByName(String name) {
        String sql = "SELECT c.idcinema,c.name,c.address,c.quantily,c.khuvuc from Cinema c where c.name like '%" + name + "%'";
        Query query = entityManager.createQuery(sql);
        List<Cinema> listByName = query.getResultList();
        if (listByName.isEmpty()) {
            return null;
        }
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonByName = null;
        try {
            jsonByName = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(listByName);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonByName;
    }
}
