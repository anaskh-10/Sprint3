package com.Anas.Pc.service;

import com.Anas.Pc.dto.PcDTO;
import com.Anas.Pc.entities.Fournisseur;
import com.Anas.Pc.entities.Pc;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PcService {
    PcDTO savePc(PcDTO p);
    PcDTO getPc(Long id);
    List<PcDTO> getAllPcs();

    PcDTO updatePc(PcDTO p);
    void deletePc(Pc p);
    void deletePcById(Long id);


    Page<Pc> getAllPcsParPage(int page, int size);
    List<Pc>findByMarquePc(String nom);
    List<Pc>findByReferencePc(String nom);
    List<Pc> findByFournisseur (Fournisseur fournisseur);
    List<Pc>findByMarquePrixPc(String nom,Double prix);
    List<Pc>findByFournisseurId(Long id);
    List<Pc>findByOrderByMarquePcAsc();
    List<Pc>trierPcsMarquePrixPc();
    List<Fournisseur>getAllFournisseur();
    PcDTO convertEntityToDto(Pc pc);
    Pc convertDtoToEntity(PcDTO pcDTO);

}
