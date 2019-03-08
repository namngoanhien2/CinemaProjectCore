package controller;

import Service.MovieFindAllService;
import entity.Cinema;
import org.json.simple.JSONObject;

public class MovieFindAllController extends HandlerNoUseToken {
    @Override
    public String doProcessPost(JSONObject params, Cinema cinema) {
        MovieFindAllService movieFindAllService = new MovieFindAllService();
        return movieFindAllService.findAll();
    }
}
