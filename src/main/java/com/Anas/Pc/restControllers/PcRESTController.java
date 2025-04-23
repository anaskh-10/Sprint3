package com.Anas.Pc.restControllers;

import com.Anas.Pc.entities.Pc;
import com.Anas.Pc.service.PcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class PcRESTController {
    @Autowired
    PcService pcService;
    @RequestMapping(method = RequestMethod.GET)
    List<Pc>getAllPcs(){
        return pcService.getAllPcs();
    }
    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public Pc getPcById(@PathVariable("id") Long id) {
        return pcService.getPc(id);
    }
    @RequestMapping(method = RequestMethod.POST)
    public Pc createPc(@RequestBody Pc pc) {
        return pcService.savePc(pc);
    }
    @RequestMapping(method = RequestMethod.PUT)
    public Pc updatePc(@RequestBody Pc pc) {
        return pcService.updatePc(pc);
    }
    @RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    public void deletePc(@PathVariable("id") Long id)
    {
        pcService.deletePcById(id);
    }
    @RequestMapping(value="/pcFour/{id}",method = RequestMethod.GET)
    public List<Pc> findByFournissuerId(@PathVariable("id") Long id) {
        return pcService.findByFournisseurId(id);
    }

}
