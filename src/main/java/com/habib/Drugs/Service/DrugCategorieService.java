package com.habib.Drugs.Service;

import com.habib.Drugs.entities.Drug;
import com.habib.Drugs.entities.DrugCategorie;
import org.springframework.data.domain.Page;

import java.util.List;

public interface DrugCategorieService {
    //crud
    DrugCategorie saveDrugCategorie(DrugCategorie d);
    DrugCategorie updateDrugCategorie(DrugCategorie d);
    void deleteDrugCategorie(DrugCategorie d);
    void deleteDrugCategorieById(Long id);
    DrugCategorie getDrugCategorie(Long id);
    List<DrugCategorie> getAllDrugCategories();
    Page<DrugCategorie> getAllDrugsCategoriesParPage(int page, int size);

}
