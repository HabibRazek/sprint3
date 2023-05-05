package com.habib.Drugs.restcontrollers;

import com.habib.Drugs.Service.DrugService;
import com.habib.Drugs.entities.Drug;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class DrugRESTController {
    @Autowired
    DrugService drugService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Drug> getAllDrugs(){
        return drugService.getAllDrugs();
    }

    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public Drug getDrugById(@PathVariable("id") Long id){
        return drugService.getDrug(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Drug saveDrug(@RequestBody Drug d){
        return drugService.saveDrug(d);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Drug updateDrug(@RequestBody Drug d){
        return drugService.updateDrug(d);
    }

    @RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    public void deleteDrug(@PathVariable("id") Long id){
        drugService.deleteDrugById(id);
    }

    @RequestMapping(value="/DrugCat/{idDrugCat}",method = RequestMethod.GET)
    public List<Drug> findByCategorieIdDrugCat(@PathVariable("idDrugCat") Long idDrugCat){
        return drugService.findByCategorieIdDrugCat(idDrugCat);
    }



}
