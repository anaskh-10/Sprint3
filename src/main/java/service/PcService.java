package service;

import entities.Pc;
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

}
