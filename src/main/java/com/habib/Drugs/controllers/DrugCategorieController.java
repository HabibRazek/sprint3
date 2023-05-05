package com.habib.Drugs.controllers;

import com.habib.Drugs.Service.DrugCategorieService;
import com.habib.Drugs.entities.DrugCategorie;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DrugCategorieController {
    @Autowired
    DrugCategorieService drugCategorieService;


    @RequestMapping("/Create")
    public String Create(ModelMap modelMap)
    {
        modelMap.addAttribute("drugCategory", new DrugCategorie());
        modelMap.addAttribute("mode", "new");
        return "formDrugCategory";
    }


    @RequestMapping("/SaveDrugCategory")
    public String saveDrugCategory(@Valid DrugCategorie drugCategorie,
                           BindingResult bindingResult)
    {
        if (bindingResult.hasErrors()) return "formDrugCategory";

        drugCategorieService.saveDrugCategorie(drugCategorie);
        return "redirect:/ListeDrugCategories";
    }

    @RequestMapping("/ListeDrugCategories")
    public String ListeDrugCategories (ModelMap modelMap,
                             @RequestParam(name="page",defaultValue = "0") int page,
                             @RequestParam (name="size", defaultValue = "2") int size)
    {
        Page<DrugCategorie> dru = drugCategorieService.getAllDrugsCategoriesParPage(page, size);
        modelMap.addAttribute("drugCategories", dru);
        modelMap.addAttribute("pages", new int[dru.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        return "listeDrugCategories";
    }


    @RequestMapping("/modifierDrugCategory")
    public String editerDrugCategory(@RequestParam("id") Long id,
                                     ModelMap modelMap)
    {
        DrugCategorie d = drugCategorieService.getDrugCategorie(id);
        modelMap.addAttribute("drugCategory", d);
        modelMap.addAttribute("mode", "edit");
        return "formDrugCategory";
    }






}
