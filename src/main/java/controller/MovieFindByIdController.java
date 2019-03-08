package controller;

import Service.MovieFindByIdService;
import entity.Cinema;
import org.json.simple.JSONObject;

public class MovieFindByIdController extends HandlerNoUseToken {

    @Override
    public String doProcessPost(JSONObject params, Cinema cinema) {
        MovieFindByIdService movieFindByIdService = new MovieFindByIdService();
        int paramID = Integer.parseInt(params.get("idmovie").toString());
        return movieFindByIdService.findById(paramID);
    }
}
