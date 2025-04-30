package com.Anas.Pc.service;

import com.Anas.Pc.dto.PcDTO;
import com.Anas.Pc.entities.Fournisseur;
import com.Anas.Pc.entities.Pc;
import com.Anas.Pc.repos.FournisseurRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.Anas.Pc.repos.PcRepository;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PcServiceImpl implements PcService{
    @Autowired
    PcRepository pcRepository;

    @Autowired
    FournisseurRepository fournisseurRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public PcDTO savePc(PcDTO p) {
        return convertEntityToDto(pcRepository.save(convertDtoToEntity(p))) ;
    }

    @Override
    public PcDTO getPc(Long id) {
        return convertEntityToDto(pcRepository.findById(id).get());
    }

    @Override
    public List<PcDTO> getAllPcs() {
        return pcRepository.findAll().stream()
                .map(this::convertEntityToDto).collect(Collectors.toList()) ;
    }

    @Override
    public PcDTO updatePc(PcDTO pc) {
        return convertEntityToDto(pcRepository.save(convertDtoToEntity(pc)));
    }

    @Override
    public void deletePc(Pc p) {
        pcRepository.delete(p);
    }

    @Override
    public void deletePcById(Long id) {
        pcRepository.deleteById(id);
    }



    @Override
    public Page<Pc> getAllPcsParPage(int page, int size) {
        return pcRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public List<Pc> findByMarquePc(String nom) {
        return pcRepository.findByMarquePc(nom);
    }

    @Override
    public List<Pc> findByReferencePc(String nom) {
        return pcRepository.findByReferencePc(nom);
    }

    @Override
    public List<Pc> findByFournisseur(Fournisseur fournisseur) {
        return pcRepository.findByFournisseur(fournisseur);    }

    @Override
    public List<Pc> findByMarquePrixPc(String nom, Double prix) {
        return pcRepository.findByMarquePrixPc(nom,prix);
    }

    @Override
    public List<Pc> findByFournisseurId(Long id) {
        return pcRepository.findByFournisseurId(id);
    }

    @Override
    public List<Pc> findByOrderByMarquePcAsc() {
        return pcRepository.findByOrderByMarquePcAsc();
    }

    @Override
    public List<Pc> trierPcsMarquePrixPc() {
        return pcRepository.trierPcsMarquePrixPc();
    }

    @Override
    public List<Fournisseur> getAllFournisseur() {
        return fournisseurRepository.findAll();
    }

    @Override
    public PcDTO convertEntityToDto(Pc pc) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(pc,PcDTO.class);
//        pcDTO.setIdPc(pc.getIdPc());
//        pcDTO.setMarquePc(pc.getMarquePc());
//        pcDTO.setReferencePc(pc.getReferencePc());
//        pcDTO
//        return PcDTO.builder()
//                .idPc(pc.getIdPc())
//                .marquePc(pc.getMarquePc())
//                .referencePc(pc.getReferencePc())
//                .prixPc(pc.getPrixPc())
//                .dateCreation(pc.getDateCreation())
//                .fournisseur(pc.getFournisseur())
//                .build();
    }

    @Override
    public Pc convertDtoToEntity(PcDTO pcDTO) {
        Pc pc=new Pc();
        pc=modelMapper.map(pcDTO, Pc.class);
//        pc.setIdPc(pcDTO.getIdPc());
//        pc.setMarquePc(pcDTO.getMarquePc());
//        pc.setReferencePc(pcDTO.getReferencePc());
//        pc.setPrixPc(pcDTO.getPrixPc());
//        pc.setDateCreation(pcDTO.getDateCreation());
//        pc.setFournisseur(pcDTO.getFournisseur());
        return pc;
    }
}
