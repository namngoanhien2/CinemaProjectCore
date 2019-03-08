package Service;

import Repo.RepoCinema;

public class CinemaFindAllService {
    public String findAll(){
        RepoCinema servicecinema = new RepoCinema();
        String listAll = servicecinema.listAll();
        return listAll;
    }
}
