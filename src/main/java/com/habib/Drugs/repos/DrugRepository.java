package com.habib.Drugs.repos;

import com.habib.Drugs.entities.Drug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DrugRepository extends JpaRepository<Drug, Long>{
    List<Drug> findByName(String name);
    List<Drug> findByNameContains(String name);

    @Query("select d from Drug d where d.name like %?1 and d.dosage=?2")
    List<Drug> findByNameContainsAndDosage(String name, Double dosage);

    @Query("select d from Drug d where d.name like %:name and d.dosage=:dosage")
    List<Drug> findByNameContainsAndDosage2(@Param("name") String name, @Param("dosage") Double dosage);


    @Query("select d from Drug d where d.categorie.idDrugCat = :id")
    List<Drug> findByCategorie(@Param("id") Long id);


    List<Drug> findByCategorieIdDrugCat(Long id);

    List<Drug> findByOrderByNameAsc();

    @Query("select d from Drug d order by d.name ASC, d.dosage ASC")
    List<Drug> trierDrugsNomsDosages();

}
