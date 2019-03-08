package Service;

import Repo.RepoTicket;
import org.json.simple.JSONObject;

public class BookTicketByCinemaService {
    public String BookTicketByCinema(int idticket, String status,int idroom, int idrap, int idmove, int iduser){
        RepoTicket repoTicket = new RepoTicket();
        JSONObject js = new JSONObject();

        if(repoTicket.existsByTransId(idticket)){
            js.put("rc", "-1");
            js.put("rd", "err");
        }else if(repoTicket.checkCinema(idrap)){
            repoTicket.BookTicketByCinema(idticket,status,idroom,idrap,idmove,iduser);
            js.put("rc", "1");
            js.put("rd", "Book success!!");
        }
        return js.toString();
    }
}
