package controller;

import Service.BookTicketByMovieService;
import entity.Cinema;
import entity.User;
import org.json.simple.JSONObject;

public class BookingTicketByMovieController extends HandlerByToken {
    @Override
    public String doProcessPost(JSONObject params, User user) {
        JSONObject js = new JSONObject();
        if(user.getRole()==1) {
            BookTicketByMovieService bookTicketByMovieService = new BookTicketByMovieService();
            int paramIdtiket = Integer.parseInt(params.get("idticket").toString());
            String paramstatus = params.get("status").toString();
            int paramIdroom = Integer.parseInt(params.get("idroom").toString());
            int paramIdrap = Integer.parseInt(params.get("idrap").toString());
            int paramIdmovie = Integer.parseInt(params.get("idmovie").toString());
            int paramIduser = Integer.parseInt(params.get("iduser").toString());
            String ListRegister = bookTicketByMovieService.BookTicketByMovie(paramIdtiket, paramstatus, paramIdroom, paramIdrap, paramIdmovie, paramIduser);
            return ListRegister;
        }else {
            js.put("rc", "-1");
            js.put("rd", "Not Support");
        }
        return null;
    }
}
