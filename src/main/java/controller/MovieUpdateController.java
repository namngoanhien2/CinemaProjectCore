package controller;

import Service.MovieUpdateService;
import entity.Cinema;
import entity.User;
import org.json.simple.JSONObject;

public class MovieUpdateController extends HandlerByToken {
    @Override
    public String doProcessPost(JSONObject params, User user) {
        JSONObject js = new JSONObject();
        if (user.getRole() == 1) {
            MovieUpdateService movieUpdateService = new MovieUpdateService();
            return movieUpdateService.updateMovie(params);
        } else {
            js.put("rc", "-1");
            js.put("rd", "Not Support");
        }
        return null;
    }
}
