package entity;

import javax.persistence.*;

@Entity
@Table(name = "movie", schema = "cenima")
public class Movie {
    private int idmovie;
    private String title;
    private String discription;
    private Integer duration;
    private String language;
    private String trailler;
    private String verification;
    private String status;
    private int idcategory;
    private int iddirectors;
    private int idactor;
    private int idcinema;

    @Id
    @Column(name = "idmovie", nullable = false)
    public int getIdmovie() {
        return idmovie;
    }

    public void setIdmovie(int idmovie) {
        this.idmovie = idmovie;
    }

    @Basic
    @Column(name = "title", nullable = true, length = 45)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "discription", nullable = true, length = -1)
    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    @Basic
    @Column(name = "duration", nullable = true)
    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @Basic
    @Column(name = "language", nullable = true, length = 45)
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Basic
    @Column(name = "trailler", nullable = true, length = 45)
    public String getTrailler() {
        return trailler;
    }

    public void setTrailler(String trailler) {
        this.trailler = trailler;
    }

    @Basic
    @Column(name = "verification", nullable = true, length = 45)
    public String getVerification() {
        return verification;
    }

    public void setVerification(String verification) {
        this.verification = verification;
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
    @Column(name = "idcategory", nullable = false)
    public int getIdcategory() {
        return idcategory;
    }

    public void setIdcategory(int idcategory) {
        this.idcategory = idcategory;
    }

    @Basic
    @Column(name = "iddirectors", nullable = false)
    public int getIddirectors() {
        return iddirectors;
    }

    public void setIddirectors(int iddirectors) {
        this.iddirectors = iddirectors;
    }

    @Basic
    @Column(name = "idactor", nullable = false)
    public int getIdactor() {
        return idactor;
    }

    public void setIdactor(int idactor) {
        this.idactor = idactor;
    }

    @Basic
    @Column(name = "idcinema", nullable = false)
    public int getIdcinema() {
        return idcinema;
    }

    public void setIdcinema(int idcinema) {
        this.idcinema = idcinema;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie that = (Movie) o;

        if (idmovie != that.idmovie) return false;
        if (idcategory != that.idcategory) return false;
        if (iddirectors != that.iddirectors) return false;
        if (idactor != that.idactor) return false;
        if (idcinema != that.idcinema) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (discription != null ? !discription.equals(that.discription) : that.discription != null) return false;
        if (duration != null ? !duration.equals(that.duration) : that.duration != null) return false;
        if (language != null ? !language.equals(that.language) : that.language != null) return false;
        if (trailler != null ? !trailler.equals(that.trailler) : that.trailler != null) return false;
        if (verification != null ? !verification.equals(that.verification) : that.verification != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idmovie;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (discription != null ? discription.hashCode() : 0);
        result = 31 * result + (duration != null ? duration.hashCode() : 0);
        result = 31 * result + (language != null ? language.hashCode() : 0);
        result = 31 * result + (trailler != null ? trailler.hashCode() : 0);
        result = 31 * result + (verification != null ? verification.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + idcategory;
        result = 31 * result + iddirectors;
        result = 31 * result + idactor;
        result = 31 * result + idcinema;
        return result;
    }
}
