package Service;

import Repo.RepoMovie;
import entity.Movie;
import org.json.simple.JSONObject;

import java.util.List;

public class MovieUpdateService {
    public String updateMovie(JSONObject movie){
        RepoMovie repoMovie = new RepoMovie();
        Movie moive = new Movie();
        JSONObject js = new JSONObject();
        int idmoive = moive.getIdmovie();
        if(idmoive==0){
            return null;
        }else {
            List<Movie> list = repoMovie.updateMovie(movie);
            if(list.isEmpty()){
                js.put("rc", "-1");
                js.put("rd", "Err");
            }else {
                js.put("rc", "1");
                js.put("rd", "Register success");
            }
        }
        return js.toString();
    }
}
