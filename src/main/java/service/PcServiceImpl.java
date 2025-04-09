package service;

import entities.Pc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import repos.PcRepository;

import java.util.List;

public class PcServiceImpl implements PcService{
    @Autowired
    PcRepository pcRepository;

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
}
