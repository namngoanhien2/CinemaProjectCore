package Service;

import Repo.RepoCinema;

public class CinemaFindByNameService {
    public String findByName(String name){
        RepoCinema servicecinema = new RepoCinema();
        String findByName =servicecinema.findByName(name);
        return findByName;
    }
}
