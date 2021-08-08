/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.FormationAngularSpring.Model.Entities;

import java.time.Year;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name= "brandEngine")
public class BrandEngine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "year")
    private Year year;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Brand> brands;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Engine> engines;


    public BrandEngine(Year year) {
        this.year = year;
    }

    public BrandEngine(Year year, List<Brand> brands, List<Engine> engines) {
        this.year = year;
        this.brands = brands;
        this.engines = engines;
    }



    public BrandEngine() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }
//public List<Brand> getBrands() {
      //  return brands;
    //}

    //public void setBrands(List<Brand> brands) {
      //  this.brands = brands;
    //}

    //public List<Engine> getEngines() {
      //  return engines;
    //}

    //public void setEngines(List<Engine> engines) {
      //  this.engines = engines;
    }

    
    
    

