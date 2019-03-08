package Repo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Cinema;
import entity.Movie;
import org.json.simple.JSONObject;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class RepoMovie extends BaseRepo {

    public String findMovie() {
        String sql = "SELECT m.idmovie,m.title,m.discription,m.duration,m.language"
                + ",m.trailler,m.verification,m.status, m.idcategory,m.iddirectors,m.idactor,m.idcinema "
                + "from Movie m ";
        Query query = entityManager.createQuery(sql);
        List<Movie> list = query.getResultList();
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

    public Movie findMovieById(int idmovie) {
        Movie movie = entityManager.find(Movie.class, idmovie);
        entityManager.detach(movie);
        return movie;
    }

    public List<Movie> updateMovie(JSONObject movie) {
        String sql = "update Movie m set m.title =?,m.discription =?,m.duration=?,m.language=?," +
                "m.trailler=?,m.verification=?,m.status=?, m.idcategory=?,m.iddirectors=?,m.idactor=?,m.idcinema=? " +
                "where m.idmovie like'%" + movie + "%'";
        Query query = entityManager.createQuery(sql);
        List<Movie> list = query.getResultList();

        if (list.isEmpty()) {
            return null;
        } else {
            entityManager.getTransaction().begin();
            entityManager.merge(list);
            entityManager.getTransaction().commit();
        }
        return list;
    }

    public String findMovieByName(String name) {
        String sql = "SELECT m.idmovie,m.title,m.discription,m.duration,m.language"
                + ",m.trailler,m.verification,m.status, m.idcategory,m.iddirectors,m.idactor,m.idcinema "
                + "from Movie m where m.title like '%" + name + "%'";
        Query query = entityManager.createQuery(sql);
        List<Movie> listByName = query.getResultList();
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
