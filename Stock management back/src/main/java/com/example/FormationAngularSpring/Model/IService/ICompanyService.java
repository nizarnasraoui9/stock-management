/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.FormationAngularSpring.Model.IService;

import com.example.FormationAngularSpring.Model.Entities.Company;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface ICompanyService {
    public List<Company> getAllCompanies();
    public Company createCompany(Company company);
    public ResponseEntity<Company> getCompanyById(int id);
    public ResponseEntity editCompany(int id, Company company);
    public ResponseEntity<Map<String, Boolean>> deleteCompany(int id);
}
