package com.habib.Drugs.Service;

import com.habib.Drugs.entities.DrugCategorie;
import com.habib.Drugs.repos.DrugCategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrugCategorieServiceImpl implements DrugCategorieService{
    @Autowired
    DrugCategorieRepository drugCategorieRepository;

    @Override
    public DrugCategorie saveDrugCategorie(DrugCategorie d) {
        return drugCategorieRepository.save(d);
    }

    @Override
    public DrugCategorie updateDrugCategorie(DrugCategorie d) {
        return drugCategorieRepository.save(d);
    }

    @Override
    public void deleteDrugCategorie(DrugCategorie d) {
        drugCategorieRepository.delete(d);
    }

    @Override
    public void deleteDrugCategorieById(Long id) {
        drugCategorieRepository.deleteById(id);
    }

    @Override
    public DrugCategorie getDrugCategorie(Long id) {
        return drugCategorieRepository.findById(id).get();
    }

    @Override
    public List<DrugCategorie> getAllDrugCategories() {
        return drugCategorieRepository.findAll();
    }

    @Override
    public Page<DrugCategorie> getAllDrugsCategoriesParPage(int page, int size) {
        return drugCategorieRepository.findAll(PageRequest.of(page, size));
    }


}
