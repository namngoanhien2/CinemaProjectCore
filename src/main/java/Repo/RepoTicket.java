package Repo;

import entity.Ticket;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;


public class RepoTicket extends BaseRepo {
    public List<Ticket> BookTicketByCinema(int idticket, String status, int idroom, int idrap, int idmove, int iduser) {
        entityManager.getTransaction().begin();
        Ticket ticket = new Ticket();
        ticket.setIdticket(idticket);
        ticket.setStatus(status);
        ticket.setIdroom(idroom);
        ticket.setIdrap(idrap);
        ticket.setIdmovie(idmove);
        ticket.setIduser(iduser);
        entityManager.persist(ticket);
        entityManager.getTransaction().commit();
        List<Ticket> list = new ArrayList<>();
        list.add(ticket);
        return list;
    }

    public boolean checkCinema(int idrap) {
        String sql = "SELECT c.idcinema from Cinema c";
        Query query = entityManager.createQuery(sql);
        List<Integer> list = query.getResultList();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == idrap) {
                return true;
            }
        }
        return false;
    }

    public boolean checkMovie(int idmovie) {
        String sql = "SELECT m.idmovie from Movie m";
        Query query = entityManager.createQuery(sql);
        List<Integer> list = query.getResultList();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == idmovie) {
                return true;
            }
        }
        return false;
    }

    public boolean existsByTransId(int id) {
        Ticket ticket = new Ticket();
        if (id == ticket.getIdticket()) {
            return true;
        }
        return false;
    }
}
