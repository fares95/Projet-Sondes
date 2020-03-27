package com.example.demo_mongo.service;

import com.example.demo_mongo.model.Etudiant;
import com.example.demo_mongo.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtudiantService {

    @Autowired
    private EtudiantRepository etudiantRepository;

    //create operation
    public Etudiant Create(String firstname, String lastName, int age) {

        return etudiantRepository.save(new Etudiant(firstname,lastName,age));

    }
    //Retrive operation
    public List<Etudiant> getAll(){
        return etudiantRepository.findAll();
    }
    public Etudiant getByFirsteName(String firstName){
        return etudiantRepository.findByFirstName(firstName);
    }
    public Etudiant update(String firstName,String lastName,int age){
        Etudiant p = etudiantRepository.findByFirstName(firstName);
        p.setFirstName(firstName);
        p.setLastName(lastName);
        p.setAge(age);
        return etudiantRepository.save(p);
    }

    //Delete methode
    public void deleteAll(){
        etudiantRepository.deleteAll();

    }
    public void delete(String firstname){
        Etudiant p = etudiantRepository.findByFirstName(firstname);
        etudiantRepository.delete(p);
    }

}