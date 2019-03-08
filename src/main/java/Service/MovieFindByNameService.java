package Service;

import Repo.RepoMovie;

public class MovieFindByNameService {

    public String findByName(String name){
        RepoMovie repoMovie = new RepoMovie();
        String findByName =repoMovie.findMovieByName(name);
        return findByName;
    }
}
