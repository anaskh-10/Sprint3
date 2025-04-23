package com.Anas.Pc.service;

import com.Anas.Pc.entities.Fournisseur;
import com.Anas.Pc.entities.Pc;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PcService {
    Pc savePc(Pc p);
    Pc updatePc(Pc p);
    void deletePc(Pc p);
    void deletePcById(Long id);
    Pc getPc(Long id);
    List<Pc> getAllPcs();
    Page<Pc> getAllPcsParPage(int page, int size);
    List<Pc>findByMarquePc(String nom);
    List<Pc>findByReferencePc(String nom);
    List<Pc> findByFournisseur (Fournisseur fournisseur);
    List<Pc>findByMarquePrixPc(String nom,Double prix);
    List<Pc>findByFournisseurId(Long id);
    List<Pc>findByOrderByMarquePcAsc();
    List<Pc>trierPcsMarquePrixPc();
    List<Fournisseur>getAllFournisseur();

}
