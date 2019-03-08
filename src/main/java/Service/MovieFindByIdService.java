package Service;

import Repo.RepoMovie;
import entity.Movie;

import java.util.ArrayList;

public class MovieFindByIdService {
    public String findById(int idmoive){
        RepoMovie repoMovie = new RepoMovie();
        Movie movie = repoMovie.findMovieById(idmoive);
        ArrayList<Movie> list = new ArrayList<>();
        list.add(movie);
        return list.toString();
    }
}
