package com.habib.Drugs.controllers;

import com.habib.Drugs.Service.DrugCategorieService;
import com.habib.Drugs.Service.DrugService;
import com.habib.Drugs.entities.Drug;
import com.habib.Drugs.entities.DrugCategorie;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class DrugController {
@Autowired
    DrugService drugService;
@Autowired
DrugCategorieService drugCategorieService;
    @RequestMapping("/showCreate")
    public String showCreate(ModelMap modelMap)
    {
        List<DrugCategorie> drugCategories = drugCategorieService.getAllDrugCategories();
        modelMap.addAttribute("drug", new Drug());
        modelMap.addAttribute("mode", "new");
        modelMap.addAttribute("drugCategories", drugCategories);
        return "formDrug";
    }




    @RequestMapping("/saveDrug")
    public String saveDrug(@Valid Drug drug,
                              BindingResult bindingResult)
    {
        if (bindingResult.hasErrors()) return "formDrug";

        drugService.saveDrug(drug);
        return "formDrug";
    }


    @RequestMapping("/ListeDrugs")
    public String listeDrugs(ModelMap modelMap,
                                @RequestParam (name="page",defaultValue = "0") int page,
                                @RequestParam (name="size", defaultValue = "2") int size)
    {
        Page<Drug> dru = drugService.getAllDrugsParPage(page, size);
        modelMap.addAttribute("drugs", dru);
        modelMap.addAttribute("pages", new int[dru.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        return "listeDrugs";
    }
    @RequestMapping("/supprimerDrug")
    public String supprimerDrug(@RequestParam("id") Long id,
                                   ModelMap modelMap,
                                   @RequestParam (name="page",defaultValue = "0") int page,
                                   @RequestParam (name="size", defaultValue = "2") int size)
    {
        drugService.deleteDrugById(id);
        Page<Drug> dru = drugService.getAllDrugsParPage(page,size);
        modelMap.addAttribute("drugs", dru);
        modelMap.addAttribute("pages", new int[dru.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("size", size);
        return "listeDrugs";
    }


    @RequestMapping("/modifierDrug")
    public String editerDrug(@RequestParam("id") Long id,ModelMap modelMap)
    {
        Drug d= drugService.getDrug(id);

        List<DrugCategorie> drugCategories = drugCategorieService.getAllDrugCategories();
        modelMap.addAttribute("drug", d);
        modelMap.addAttribute("drugCategories", drugCategories);
        modelMap.addAttribute("selectedDrugcat", d.getCategorie());
        modelMap.addAttribute("mode", "edit");
        return "formDrug";
    }



    @RequestMapping("/updateDrug")
    public String updateDrug(@ModelAttribute("drug") Drug drug, @RequestParam("date") String date, ModelMap modelMap) throws ParseException {
        //conversion de la date
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateCreation = dateformat.parse(String.valueOf(date));
        drug.setDateCreation(dateCreation);

        drugService.updateDrug(drug);
        return "redirect:/ListeDrugs";
    }


}
