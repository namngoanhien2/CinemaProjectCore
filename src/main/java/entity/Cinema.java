package entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cinema", schema = "cenima")
public class Cinema implements Serializable {
    private int idcinema;
    private String name;
    private String address;
    private Integer quantily;
    private String khuvuc;

    @Id
    @Column(name = "idcinema", nullable = false)
    public int getIdcinema() {
        return idcinema;
    }

    public void setIdcinema(int idcinema) {
        this.idcinema = idcinema;
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
    @Column(name = "address", nullable = true, length = 45)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "quantily", nullable = true)
    public Integer getQuantily() {
        return quantily;
    }

    public void setQuantily(Integer quantily) {
        this.quantily = quantily;
    }

    @Basic
    @Column(name = "khuvuc", nullable = true, length = 45)
    public String getKhuvuc() {
        return khuvuc;
    }

    public void setKhuvuc(String khuvuc) {
        this.khuvuc = khuvuc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cinema that = (Cinema) o;

        if (idcinema != that.idcinema) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (quantily != null ? !quantily.equals(that.quantily) : that.quantily != null) return false;
        if (khuvuc != null ? !khuvuc.equals(that.khuvuc) : that.khuvuc != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idcinema;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (quantily != null ? quantily.hashCode() : 0);
        result = 31 * result + (khuvuc != null ? khuvuc.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "idcinema=" + idcinema +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", quantily=" + quantily +
                ", khuvuc='" + khuvuc + '\'' +
                '}';
    }
}
