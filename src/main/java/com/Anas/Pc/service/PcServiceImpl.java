package com.Anas.Pc.service;

import com.Anas.Pc.entities.Fournisseur;
import com.Anas.Pc.entities.Pc;
import com.Anas.Pc.repos.FournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.Anas.Pc.repos.PcRepository;

import java.util.List;
@Service
public class PcServiceImpl implements PcService{
    @Autowired
    PcRepository pcRepository;

    @Autowired
    FournisseurRepository fournisseurRepository;

    @Override
    public Pc savePc(Pc p) {
        return pcRepository.save(p);
    }

    @Override
    public Pc updatePc(Pc p) {
        return pcRepository.save(p);
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
    public Pc getPc(Long id) {
        return pcRepository.findById(id).get();
    }

    @Override
    public List<Pc> getAllPcs() {
        return pcRepository.findAll();
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
}
