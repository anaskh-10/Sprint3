package com.Anas.Pc.controllers;

import com.Anas.Pc.entities.Fournisseur;
import com.Anas.Pc.entities.Pc;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.Anas.Pc.service.PcService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller// This will ensure the routes are prefixed with "/pcs"
public class PcController {

    @Autowired
    PcService pcService;

    @RequestMapping("/listes")
    public String listes(ModelMap modelMap,@RequestParam (name="page",defaultValue = "0") int page,
    @RequestParam (name="size", defaultValue = "2") int size) {
        Page<Pc> pcs = pcService.getAllPcsParPage(page, size);
        modelMap.addAttribute("pcs", pcs);
        modelMap.addAttribute("pages", new int[pcs.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        return "listePcs";  // Return the thymeleaf template for the list of PCs
    }

    @RequestMapping("/showCreate")
    public String showCreate(ModelMap modelMap) {
        List<Fournisseur> fours=pcService.getAllFournisseur();
        modelMap.addAttribute("pc",new Pc());
        modelMap.addAttribute("mode", "new");
        modelMap.addAttribute("fournisseur",fours);
        return "formPc";  // Return the createPc template
    }

    @RequestMapping("/savePc")
    public String savePc(@Valid Pc pc, BindingResult bindingResult,@RequestParam (name="page",defaultValue = "0") int page,
                         @RequestParam (name="size",defaultValue = "2") int size){
            int currentPage;
            boolean isNew = false;
        if(bindingResult.hasErrors())return "createPc";
        if (pc.getIdPc() ==null) //ajout
            isNew=true;
        pcService.savePc(pc);
        if (isNew) //ajout
        {
            Page<Pc> prods = pcService.getAllPcsParPage(page, size);
            currentPage = prods.getTotalPages()-1;
        }
        else //modif
            currentPage=page;
        return ("redirect:/ListeProduits?page="+currentPage+"&size="+size);
    }
    @GetMapping(value = "/")
    public String welcome() {
        return "index";
    }
    @RequestMapping("/supprimerPc")
    public String supprimerPc(@RequestParam("id") Long id, ModelMap modelMap,@RequestParam (name="page",defaultValue = "0") int page,
                              @RequestParam (name="size", defaultValue = "2") int size) {
        pcService.deletePcById(id);

        Page<Pc> pcs = pcService.getAllPcsParPage(page, size);
        modelMap.addAttribute("pcs", pcs);
        modelMap.addAttribute("pages", new int[pcs.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("size", size);
        return "listePcs";
    }

    @RequestMapping("/modifierPc")
    public String editerPc(@RequestParam("id") Long id, ModelMap modelMap) {
        // Get the PC to be edited by ID
        Pc p = pcService.getPc(id);
        List<Fournisseur> fours=pcService.getAllFournisseur();
        modelMap.addAttribute("pc", p);
        modelMap.addAttribute("mode","edit");
        modelMap.addAttribute("fournisseur",fours);
        return "formPc";  // Return the edit template
    }

    @RequestMapping("/updatePc")
    public String updatePc(@ModelAttribute("pc") Pc pc, @RequestParam("date") String date, ModelMap modelMap) throws ParseException {
        // Convert the date string to Date object
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateCreation = dateformat.parse(date);
        pc.setDateCreation(dateCreation);

        // Update the PC
        pcService.updatePc(pc);

        // Get the updated list of PCs
        List<Pc> pcs = pcService.getAllPcs();
        modelMap.addAttribute("pcs", pcs);

        return "listePcs";  // Return to the list view after update
    }
}
