package com.Anas.Pc.repos;

import com.Anas.Pc.entities.Fournisseur;
import com.Anas.Pc.entities.Pc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;
@RepositoryRestResource(path = "rest")
public interface PcRepository extends JpaRepository<Pc,Long> {
    List<Pc> findByMarquePc(String nom);
    List<Pc> findByReferencePc(String nom);
    @Query("SELECT p FROM Pc p WHERE p.marquePc = ?1 and p.prixPc>?2")
    List<Pc> findByMarquePrixPc(String nom,Double prix);
    @Query("select p from Pc p where p.fournisseur=?1")
    List<Pc> findByFournisseur(Fournisseur fournisseur);
    List<Pc> findByFournisseurId(Long id);
    List<Pc> findByOrderByMarquePcAsc();
    @Query("select p from Pc p order by p.marquePc ASC, p.prixPc DESC")
    List<Pc> trierPcsMarquePrixPc ();

}
