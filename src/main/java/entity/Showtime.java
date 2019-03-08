package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Showtime {
    private int idshowtime;
    private Date ngaychieu;
    private Integer giave;
    private int idmovie;
    private int frametime;
    private int idauditorium;

    @Id
    @Column(name = "idshowtime", nullable = false)
    public int getIdshowtime() {
        return idshowtime;
    }

    public void setIdshowtime(int idshowtime) {
        this.idshowtime = idshowtime;
    }

    @Basic
    @Column(name = "ngaychieu", nullable = true)
    public Date getNgaychieu() {
        return ngaychieu;
    }

    public void setNgaychieu(Date ngaychieu) {
        this.ngaychieu = ngaychieu;
    }

    @Basic
    @Column(name = "giave", nullable = true)
    public Integer getGiave() {
        return giave;
    }

    public void setGiave(Integer giave) {
        this.giave = giave;
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
    @Column(name = "frametime", nullable = false)
    public int getFrametime() {
        return frametime;
    }

    public void setFrametime(int frametime) {
        this.frametime = frametime;
    }

    @Basic
    @Column(name = "idauditorium", nullable = false)
    public int getIdauditorium() {
        return idauditorium;
    }

    public void setIdauditorium(int idauditorium) {
        this.idauditorium = idauditorium;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Showtime showtime = (Showtime) o;

        if (idshowtime != showtime.idshowtime) return false;
        if (idmovie != showtime.idmovie) return false;
        if (frametime != showtime.frametime) return false;
        if (idauditorium != showtime.idauditorium) return false;
        if (ngaychieu != null ? !ngaychieu.equals(showtime.ngaychieu) : showtime.ngaychieu != null) return false;
        if (giave != null ? !giave.equals(showtime.giave) : showtime.giave != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idshowtime;
        result = 31 * result + (ngaychieu != null ? ngaychieu.hashCode() : 0);
        result = 31 * result + (giave != null ? giave.hashCode() : 0);
        result = 31 * result + idmovie;
        result = 31 * result + frametime;
        result = 31 * result + idauditorium;
        return result;
    }
}
