package com.habib.Drugs.restcontrollers;


import com.habib.Drugs.Service.DrugCategorieService;
import com.habib.Drugs.entities.DrugCategorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/category")
@CrossOrigin
public class DrugCategoryRESTController {
    @Autowired
    DrugCategorieService drugCategorieService;

    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public DrugCategorie getDrugCategorieById(@PathVariable("id") Long id){
        return drugCategorieService.getDrugCategorie(id);
    }


}
