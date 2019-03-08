package controller;

import Service.CinemaFindAllService;
import entity.Cinema;
import org.json.simple.JSONObject;


public class FindAllController extends HandlerNoUseToken {
    @Override
    public String doProcessPost(JSONObject params, Cinema cinema) {
        CinemaFindAllService findAllCinema = new CinemaFindAllService();
        return findAllCinema.findAll();
    }

}
