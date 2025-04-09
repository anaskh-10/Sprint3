package entities;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Pc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPc;
    @NotNull
    private String marquePc;
    @NotNull
    private String referencePc;
    @NotNull
    private Double prixPc;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateCreation;
    @OneToMany(mappedBy = "pc", cascade = CascadeType.ALL)
    private List<Component> components = new ArrayList<>();

    public Pc() {
    }
    public Long getIdPc() {
        return idPc;
    }

    public Pc(Long idPc, String marquePc, String referencePc, Double prixPc, Date dateCreation) {
        this.idPc = idPc;
        this.marquePc = marquePc;
        this.referencePc = referencePc;
        this.prixPc = prixPc;
        this.dateCreation = dateCreation;
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
