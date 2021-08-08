/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.FormationAngularSpring.Model.Entities;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name= "engine")
public class Engine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "name")
    private String name;
    
    
    //@ManyToMany
    //private List<Part> parts;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private BrandEngine brandEngine;


    @ManyToOne
    private Brand brand;

    public Engine(String name, Brand brand) {
        this.name = name;
        this.brand = brand;
    }

    public Engine(String name) {
        this.name = name;
        //this.brandEngine = brandEngine;
    }

    public Engine() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
   // public BrandEngine getbrandEngine() {
       // return brandEngine;
    //}

  //  public void setbrandEngine(BrandEngine brandEngine) {
      //  this.brandEngine = brandEngine;
    //}

    //public List<Part> getParts() {
       // return parts;
    //}

    //public void setParts(List<Part> parts) {
       // this.parts = parts;
    //}

    //public BrandEngine getBrandEngine() {
       // return brandEngine;
    //}

   // public void setBrandEngine(BrandEngine brandEngine) {
       // this.brandEngine = brandEngine;
    //}

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}
