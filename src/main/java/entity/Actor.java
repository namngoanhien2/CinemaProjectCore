package entity;

import javax.persistence.*;

@Entity
@Table(name = "actor", schema = "cenima")
public class Actor {
    private int idactor;
    private String nameactor;
    private Integer ageactor;
    private Integer sexactor;

    @Id
    @Column(name = "idactor", nullable = false)
    public int getIdactor() {
        return idactor;
    }

    public void setIdactor(int idactor) {
        this.idactor = idactor;
    }

    @Basic
    @Column(name = "nameactor", nullable = true, length = 45)
    public String getNameactor() {
        return nameactor;
    }

    public void setNameactor(String nameactor) {
        this.nameactor = nameactor;
    }

    @Basic
    @Column(name = "ageactor", nullable = true)
    public Integer getAgeactor() {
        return ageactor;
    }

    public void setAgeactor(Integer ageactor) {
        this.ageactor = ageactor;
    }

    @Basic
    @Column(name = "sexactor", nullable = true)
    public Integer getSexactor() {
        return sexactor;
    }

    public void setSexactor(Integer sexactor) {
        this.sexactor = sexactor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Actor that = (Actor) o;

        if (idactor != that.idactor) return false;
        if (nameactor != null ? !nameactor.equals(that.nameactor) : that.nameactor != null) return false;
        if (ageactor != null ? !ageactor.equals(that.ageactor) : that.ageactor != null) return false;
        if (sexactor != null ? !sexactor.equals(that.sexactor) : that.sexactor != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idactor;
        result = 31 * result + (nameactor != null ? nameactor.hashCode() : 0);
        result = 31 * result + (ageactor != null ? ageactor.hashCode() : 0);
        result = 31 * result + (sexactor != null ? sexactor.hashCode() : 0);
        return result;
    }
}
