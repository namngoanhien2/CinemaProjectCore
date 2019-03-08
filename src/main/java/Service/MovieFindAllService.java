package Service;

import Repo.RepoMovie;

public class MovieFindAllService {
    public String findAll(){
        RepoMovie repoMovie = new RepoMovie();
        String listAll = repoMovie.findMovie();
        return listAll;
    }
}
