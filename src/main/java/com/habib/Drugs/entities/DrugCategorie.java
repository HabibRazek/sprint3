package com.habib.Drugs.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class DrugCategorie{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idDrugCat;
    private String name;
    private String description;

    @OneToMany(mappedBy = "categorie")
    @JsonIgnore
    private List<Drug> drugs;
}
