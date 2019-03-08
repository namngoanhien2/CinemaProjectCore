package entity;

import javax.persistence.*;

@Entity
@Table(name = "seat", schema = "cenima")
public class Seat {
    private int idseat;
    private String row;
    private Integer seatNo;
    private String loaighe;
    private Integer status;
    private int idauditorium;

    @Id
    @Column(name = "idseat", nullable = false)
    public int getIdseat() {
        return idseat;
    }

    public void setIdseat(int idseat) {
        this.idseat = idseat;
    }

    @Basic
    @Column(name = "row", nullable = true, length = 45)
    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    @Basic
    @Column(name = "seatNo", nullable = true)
    public Integer getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(Integer seatNo) {
        this.seatNo = seatNo;
    }

    @Basic
    @Column(name = "loaighe", nullable = true, length = 45)
    public String getLoaighe() {
        return loaighe;
    }

    public void setLoaighe(String loaighe) {
        this.loaighe = loaighe;
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

        Seat that = (Seat) o;

        if (idseat != that.idseat) return false;
        if (idauditorium != that.idauditorium) return false;
        if (row != null ? !row.equals(that.row) : that.row != null) return false;
        if (seatNo != null ? !seatNo.equals(that.seatNo) : that.seatNo != null) return false;
        if (loaighe != null ? !loaighe.equals(that.loaighe) : that.loaighe != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idseat;
        result = 31 * result + (row != null ? row.hashCode() : 0);
        result = 31 * result + (seatNo != null ? seatNo.hashCode() : 0);
        result = 31 * result + (loaighe != null ? loaighe.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + idauditorium;
        return result;
    }
}
