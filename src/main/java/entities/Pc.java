package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;
@Entity
public class Pc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPc;
    private String marquePc;
    private String referencePc;
    private Double prixPc;
    private Date dateCreation;

    public Pc() {
    }

    public Pc(Long idPc, String marquePc, String referencePc, Double prixPc, Date dateCreation) {
        this.idPc = idPc;
        this.marquePc = marquePc;
        this.referencePc = referencePc;
        this.prixPc = prixPc;
        this.dateCreation = dateCreation;
    }

    public Long getIdPc() {
        return idPc;
    }

    public void setIdPc(Long idPc) {
        this.idPc = idPc;
    }

    public String getMarquePc() {
        return marquePc;
    }

    public void setMarquePc(String marquePc) {
        this.marquePc = marquePc;
    }

    public String getReferencePc() {
        return referencePc;
    }

    public void setReferencePc(String referencePc) {
        this.referencePc = referencePc;
    }

    public Double getPrixPc() {
        return prixPc;
    }

    public void setPrixPc(Double prixPc) {
        this.prixPc = prixPc;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    @Override
    public String toString() {
        return "Pc{" +
                "idPc=" + idPc +
                ", marquePc='" + marquePc + '\'' +
                ", referencePc='" + referencePc + '\'' +
                ", prixPc=" + prixPc +
                ", dateCreation=" + dateCreation +
                '}';
    }
}
