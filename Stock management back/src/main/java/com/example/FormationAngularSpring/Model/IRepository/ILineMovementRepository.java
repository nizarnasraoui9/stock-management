/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.FormationAngularSpring.Model.IRepository;

import com.example.FormationAngularSpring.Model.Entities.LineMovement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILineMovementRepository extends JpaRepository<LineMovement, Integer> {
    
}
