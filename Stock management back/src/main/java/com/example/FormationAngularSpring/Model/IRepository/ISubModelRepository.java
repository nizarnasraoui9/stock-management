/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.FormationAngularSpring.Model.IRepository;

import com.example.FormationAngularSpring.Model.Entities.Model;
import com.example.FormationAngularSpring.Model.Entities.Submodel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISubModelRepository extends JpaRepository<Submodel, Integer> {
    public List<Submodel> getSubModelsByName(String name);
}
