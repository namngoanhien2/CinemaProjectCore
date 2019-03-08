package entity;

import javax.persistence.*;

@Entity
@Table(name = "auditorium", schema = "cenima")
public class Auditorium {
    private int idauditorium;
    private String name;
    private String technology;
    private String seetNo;
    private Integer status;
    private int idcinema;

    @Id
    @Column(name = "idauditorium", nullable = false)
    public int getIdauditorium() {
        return idauditorium;
    }

    public void setIdauditorium(int idauditorium) {
        this.idauditorium = idauditorium;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "technology", nullable = true, length = 45)
    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    @Basic
    @Column(name = "seetNo", nullable = true, length = 45)
    public String getSeetNo() {
        return seetNo;
    }

    public void setSeetNo(String seetNo) {
        this.seetNo = seetNo;
    }

    @Basic
    @Column(name = "status", nullable = true)
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

        Auditorium that = (Auditorium) o;

        if (idauditorium != that.idauditorium) return false;
        if (idcinema != that.idcinema) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (technology != null ? !technology.equals(that.technology) : that.technology != null) return false;
        if (seetNo != null ? !seetNo.equals(that.seetNo) : that.seetNo != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idauditorium;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (technology != null ? technology.hashCode() : 0);
        result = 31 * result + (seetNo != null ? seetNo.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + idcinema;
        return result;
    }
}
