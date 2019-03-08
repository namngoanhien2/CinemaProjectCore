package controller;

import Service.SeatFindByShowTimeService;
import entity.Cinema;
import org.json.simple.JSONObject;

public class SeatFindByShowTimeController extends HandlerNoUseToken {
    @Override
    public String doProcessPost(JSONObject params, Cinema cinema) {
        SeatFindByShowTimeService seatFindByShowTimeService = new SeatFindByShowTimeService();
        int param =Integer.parseInt(params.get("frametime").toString());
        return seatFindByShowTimeService.findByShowTime(param);
    }
}
