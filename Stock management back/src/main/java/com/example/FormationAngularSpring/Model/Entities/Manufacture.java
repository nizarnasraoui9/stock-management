/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.FormationAngularSpring.Model.Entities;

import java.util.List;
import javax.persistence.*;


@Entity
@Table(name= "manufacture")
public class Manufacture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "name")
    private String name;
    
    
   // @OneToMany
    //private List<Part> parts;

   // @OneToOne
  //  private Image image;

    public Manufacture() {
    }

    public Manufacture(String name) {
        this.name = name;
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


   // public List<Part> getParts() {
    //    return parts;
    //}

    //public void setParts(List<Part> parts) {
      //  this.parts = parts;
    //}

   // public Image getImage() {
     //   return image;
    //}

    //public void setImage(Image image) {
      //  this.image = image;
    //}
}
