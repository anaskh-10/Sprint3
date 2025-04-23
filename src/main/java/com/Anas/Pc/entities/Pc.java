package com.Anas.Pc.entities;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
public class Pc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPc;
    @NotNull
    @Size(min = 4,max = 15)
    private String marquePc;
    @NotNull
    @Size(min = 4,max = 15)
    private String referencePc;
    @NotNull
    @Min(value = 10)
    @Max(value = 10000)
    private Double prixPc;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateCreation;
    @ManyToOne
    @JoinColumn(name="fournisseur_id")
    private Fournisseur fournisseur ;

    public Pc() {
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

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public Pc(Long idPc, String marquePc, String referencePc, Double prixPc, Date dateCreation, Fournisseur components) {
        this.idPc = idPc;
        this.marquePc = marquePc;
        this.referencePc = referencePc;
        this.prixPc = prixPc;
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
