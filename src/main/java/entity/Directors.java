package entity;

import javax.persistence.*;

@Entity
@Table(name = "directors", schema = "cenima")
public class Directors {
    private int iddirectors;
    private String namedirectors;
    private Integer agedirector;
    private Integer sexdirector;

    @Id
    @Column(name = "iddirectors", nullable = false)
    public int getIddirectors() {
        return iddirectors;
    }

    public void setIddirectors(int iddirectors) {
        this.iddirectors = iddirectors;
    }

    @Basic
    @Column(name = "namedirectors", nullable = true, length = 45)
    public String getNamedirectors() {
        return namedirectors;
    }

    public void setNamedirectors(String namedirectors) {
        this.namedirectors = namedirectors;
    }

    @Basic
    @Column(name = "agedirector", nullable = true)
    public Integer getAgedirector() {
        return agedirector;
    }

    public void setAgedirector(Integer agedirector) {
        this.agedirector = agedirector;
    }

    @Basic
    @Column(name = "sexdirector", nullable = true)
    public Integer getSexdirector() {
        return sexdirector;
    }

    public void setSexdirector(Integer sexdirector) {
        this.sexdirector = sexdirector;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Directors that = (Directors) o;

        if (iddirectors != that.iddirectors) return false;
        if (namedirectors != null ? !namedirectors.equals(that.namedirectors) : that.namedirectors != null)
            return false;
        if (agedirector != null ? !agedirector.equals(that.agedirector) : that.agedirector != null) return false;
        if (sexdirector != null ? !sexdirector.equals(that.sexdirector) : that.sexdirector != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = iddirectors;
        result = 31 * result + (namedirectors != null ? namedirectors.hashCode() : 0);
        result = 31 * result + (agedirector != null ? agedirector.hashCode() : 0);
        result = 31 * result + (sexdirector != null ? sexdirector.hashCode() : 0);
        return result;
    }
}
