package com.habib.Drugs.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
public class Drug {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDrug;
    @NotNull
    @Size(min = 4,max = 15)
    private String name;

    @Min(value = 10)
    @Max(value = 10000)
    private Double dosage;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent
    private Date dateCreation;

    @ManyToOne
    private DrugCategorie categorie;
    public Drug() {
        super();
    }
    public Drug(String name, Double dosage, Date dateCreation) {
        super();
        this.name = name;
        this.dosage = dosage;
        this.dateCreation = dateCreation;
    }
    public Long getIdDrug() {
        return idDrug;
    }
    public void setIdDrug(Long idDrug) {
        this.idDrug = idDrug;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Double getDosage() {
        return dosage;
    }
    public void setDosage(Double dosage) {
        this.dosage = dosage;
    }
    public Date getDateCreation() {
        return dateCreation;
    }
    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }
    @Override
    public String toString() {
        return "Drug [idDrug=" + idDrug + ", name=" + name + ", dosage=" + dosage
                + ", dateCreation=" + dateCreation + "]";
    }

    public DrugCategorie getCategorie() {
        return categorie;
    }
    public void setCategorie(DrugCategorie categorie) {
        this.categorie = categorie;
    }

}
