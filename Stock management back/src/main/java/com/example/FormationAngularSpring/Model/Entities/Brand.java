/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.FormationAngularSpring.Model.Entities;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name= "brand")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "name")
    private String name;
    
    //@OneToMany
    //private List<Model> models;
    
   @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   private BrandEngine brandEngine;

    //@OneToOne
   // private Image image;
    

    public Brand() {
    }

    public Brand(String name) {
        this.name = name;
        //this.models = models;
       // this.brandEngine = brandEngine;
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

    //public List<Model> getModels() {
       // return models;
    //}

    //public void setModels(List<Model> models) {
     //   this.models = models;
   // }

   // public BrandEngine getBrandEngines() {
       // return brandEngine;
   // }

    //public void setBrandEngines(BrandEngine brandEngine) {
      //  this.brandEngine = brandEngine;
    //}

   // public BrandEngine getBrandEngine() {
       // return brandEngine;
    //}

   // public void setBrandEngine(BrandEngine brandEngine) {
       // this.brandEngine = brandEngine;
    //}

    //public Image getImage() {
        //return image;
    }

    //public void setImage(Image image) {
      //  this.image = image;
   // }
//}
