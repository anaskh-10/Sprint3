package com.Anas.Pc.dto;

import com.Anas.Pc.entities.Fournisseur;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PcDTO {
    private Long idPc;
    private String marquePc;
    private String referencePc;
    private Double prixPc;
    private Date dateCreation;
    private Fournisseur fournisseur ;
    private String nom ;
}
