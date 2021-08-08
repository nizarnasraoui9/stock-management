/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.FormationAngularSpring.Model.ServiceImp;

import com.example.FormationAngularSpring.Model.Entities.Company;
import com.example.FormationAngularSpring.Model.Entities.Company;
import com.example.FormationAngularSpring.Model.IRepository.ICompanyRepository;
import com.example.FormationAngularSpring.Model.IService.ICompanyService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements ICompanyService {

    @Autowired
    private ICompanyRepository companyRepository;
    
    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company createCompany(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public ResponseEntity<Company> getCompanyById(int id) {
        Company company = companyRepository.findById(id).get();
        return ResponseEntity.ok(company);
    }

    @Override
    public ResponseEntity editCompany(int id, Company company) {
        Company companyToEdit = companyRepository.findById(id).get();
        
        companyToEdit = company;
        companyToEdit.setId(id);
        return ResponseEntity.ok(companyRepository.save(companyToEdit));
    }

    @Override
    public ResponseEntity<Map<String, Boolean>> deleteCompany(int id) {
        Company companyToDelete = companyRepository.findById(id).get();

        companyRepository.delete(companyToDelete);
        Map<String, Boolean> response = new HashMap();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
    
}
