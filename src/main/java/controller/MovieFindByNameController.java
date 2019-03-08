package controller;

import Service.MovieFindByNameService;
import entity.Cinema;
import org.json.simple.JSONObject;

public class MovieFindByNameController extends HandlerNoUseToken {

    @Override
    public String doProcessPost(JSONObject params, Cinema cinema) {
        MovieFindByNameService movieFindByNameService = new MovieFindByNameService();
        String param =params.get("name").toString();
        return movieFindByNameService.findByName(param);
    }
}
