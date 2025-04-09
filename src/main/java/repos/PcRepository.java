package repos;

import entities.Pc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PcRepository extends JpaRepository<Pc,Long> {
}
