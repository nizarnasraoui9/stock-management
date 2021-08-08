/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.FormationAngularSpring.Model.IRepository;

import com.example.FormationAngularSpring.Model.Entities.SubCategory;
import com.example.FormationAngularSpring.Model.Entities.SubSubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISubSubCategoryRepository extends JpaRepository<SubSubCategory, Integer> {
    public List<SubSubCategory> getSubsubCategoriesByTitle(String title);
    
}
