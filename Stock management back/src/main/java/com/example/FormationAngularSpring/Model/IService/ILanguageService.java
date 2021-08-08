/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.FormationAngularSpring.Model.IService;

import com.example.FormationAngularSpring.Model.Entities.Language;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface ILanguageService {
    public List<Language> getAllLanguages();
    public Language createLanguage(Language language);
    public ResponseEntity<Language> getLanguageById(int id);
    public ResponseEntity editLanguage(int id, Language language);
    public ResponseEntity<Map<String, Boolean>> deleteLanguage(int id);
}
