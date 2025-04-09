package repos;

import entities.Component;
import entities.Pc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PcRepository extends JpaRepository<Pc,Long> {
    @Query("SELECT p FROM Pc p WHERE p.marquePc = ?1")
    List<Pc> findByMarquePc(String marquePc);
    @Query("select p from Pc p where p.component = ?1")
    List<Pc> findByComponent (Component component);
}
