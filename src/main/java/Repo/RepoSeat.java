package Repo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.Query;
import java.util.List;

public class RepoSeat extends BaseRepo {
    public String FindBySeat(int time) {
        String sql = "select m.title,m.discription,m.trailler,m.language,st.ngaychieu,st.frametime,a.name,s.status,s.idseat,s.loaighe,s.row,s.seatNo" +
                " from Movie m " +
                "inner join Showtime st on m.idmovie = st.idmovie " +
                "inner join Auditorium a on a.idauditorium = st.idauditorium " +
                "inner join Seat s on s.idauditorium = a.idauditorium " +
                "where st.frametime like '%" + time + "%'";
        Query query = entityManager.createQuery(sql);
        List<String> list = query.getResultList();
        if (list.isEmpty()) {
            return null;
        }
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonByName = null;
        try {
            jsonByName = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(list);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonByName;
    }
}
