package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ticket {
    private int idticket;
    private String status;
    private int idroom;
    private int idrap;
    private int idmovie;
    private int iduser;

    @Id
    @Column(name = "idticket", nullable = false)
    public int getIdticket() {
        return idticket;
    }

    public void setIdticket(int idticket) {
        this.idticket = idticket;
    }

    @Basic
    @Column(name = "status", nullable = true, length = 45)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "idroom", nullable = false)
    public int getIdroom() {
        return idroom;
    }

    public void setIdroom(int idroom) {
        this.idroom = idroom;
    }

    @Basic
    @Column(name = "idrap", nullable = false)
    public int getIdrap() {
        return idrap;
    }

    public void setIdrap(int idrap) {
        this.idrap = idrap;
    }

    @Basic
    @Column(name = "idmovie", nullable = false)
    public int getIdmovie() {
        return idmovie;
    }

    public void setIdmovie(int idmovie) {
        this.idmovie = idmovie;
    }

    @Basic
    @Column(name = "iduser", nullable = false)
    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ticket ticket = (Ticket) o;

        if (idticket != ticket.idticket) return false;
        if (idroom != ticket.idroom) return false;
        if (idrap != ticket.idrap) return false;
        if (idmovie != ticket.idmovie) return false;
        if (iduser != ticket.iduser) return false;
        if (status != null ? !status.equals(ticket.status) : ticket.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idticket;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + idroom;
        result = 31 * result + idrap;
        result = 31 * result + idmovie;
        result = 31 * result + iduser;
        return result;
    }
}
