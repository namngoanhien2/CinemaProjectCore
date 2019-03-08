package controller;

import Service.CinemaFindByNameService;
import entity.Cinema;
import org.json.simple.JSONObject;

public class FindByNameController extends HandlerNoUseToken {
    @Override
    public String doProcessPost(JSONObject params, Cinema cinema) {
        CinemaFindByNameService cinemaFindByNameService = new CinemaFindByNameService();
        String param =params.get("name").toString();
        return cinemaFindByNameService.findByName(param);
    }
}
