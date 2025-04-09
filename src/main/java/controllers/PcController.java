package controllers;

import entities.Pc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.PcService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/pcs")  // This will ensure the routes are prefixed with "/pcs"
public class PcController {

    @Autowired
    PcService pcService;

    @RequestMapping("/listePcs")
    public String listePcs(ModelMap modelMap,@RequestParam (name="page",defaultValue = "0") int page,
    @RequestParam (name="size", defaultValue = "2") int size) {
        Page<Pc> pcs = pcService.getAllPcsParPage(page, size);
        modelMap.addAttribute("pcs", pcs);
        modelMap.addAttribute("pages", new int[pcs.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        return "listePcs";  // Return the thymeleaf template for the list of PCs
    }

    @RequestMapping("/showCreate")
    public String showCreate() {
        return "createPc";  // Return the createPc template
    }

    @RequestMapping("/savePc")
    public String savePc(@ModelAttribute("pc") Pc pc, @RequestParam("date") String date, ModelMap modelMap) throws ParseException {
        // Conversion of date string to Date object
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateCreation = dateformat.parse(date);
        pc.setDateCreation(dateCreation);

        // Save the PC to the database
        Pc savedPc = pcService.savePc(pc);

        // Add a success message to be shown in the view
        String msg = "PC enregistré avec ID " + savedPc.getIdPc();
        modelMap.addAttribute("msg", msg);

        return "createPc";  // Return the createPc template again after saving
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
        modelMap.addAttribute("pc", p);
        return "editerPc";  // Return the edit template
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
