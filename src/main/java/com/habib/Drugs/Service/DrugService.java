package com.habib.Drugs.Service;

import com.habib.Drugs.entities.Drug;
import org.springframework.data.domain.Page;

import java.util.List;

public interface DrugService {
    Drug saveDrug(Drug d);
    Drug updateDrug(Drug d);
    void deleteDrug(Drug d);
    void deleteDrugById(Long id);
    Drug getDrug(Long id);
    List<Drug> getAllDrugs();
    Page<Drug> getAllDrugsParPage(int page, int size);

    //implementation of all repository methods
List<Drug> findByNomDrug(String name);
List<Drug> findByNomDrugContains(String name);
List<Drug> findByNomDrugContainsAndDosage(String name, Double dosage);
List<Drug> findByNomDrugContainsAndDosage2(String name, Double dosage);
List<Drug> findByCategorie(Long id);
List<Drug> findByCategorieIdDrugCat(Long id);
List<Drug> findByOrderByNomDrugAsc();
List<Drug> trierDrugsNomsDosages();

}
