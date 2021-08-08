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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name= "sub_sub_category")
public class SubSubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "title")
    private String title;

    @ManyToOne
    private SubCategory subCategory;

    //@OneToMany(cascade = CascadeType.ALL)
    //private List<Part> parts;

    @Override
    public String toString() {
        return "SubSubCategory{" + "id=" + id + ", title=" + title + ", subcategory=" + subCategory + '}';
    }

    public SubSubCategory(String title, SubCategory subCategory) {
        this.title = title;
        this.subCategory = subCategory;

    }

    public SubSubCategory() {
    }




    public SubCategory getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}
