package com.example.demo_mongo.controller;

import com.example.demo_mongo.model.Etudiant;
import com.example.demo_mongo.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
class EtudiantController {
    @Autowired
    private EtudiantService etudiantService;

    @RequestMapping("/create")
    public String create(@RequestParam String firstName,@RequestParam String lastName,int age){
        Etudiant p = etudiantService.Create(firstName,lastName,age);
        return p.toString();

    }
    @RequestMapping("/get")
    public Etudiant getPerson(@RequestParam String firstName){
        return etudiantService.getByFirsteName(firstName);
    }
    @RequestMapping("/getAll")
    public List<Etudiant> getAll(){
        return  etudiantService.getAll();
    }
    @RequestMapping("/update")
    public String update(@RequestParam String firstName,@RequestParam String lastName,int age){

        Etudiant p = etudiantService.update(firstName,lastName,age);
        return p.toString();
    }
    @RequestMapping("/delete")
    public String delete(@RequestParam String firstName){
        etudiantService.delete(firstName);
        return "Deleted"+firstName;
    }

    @RequestMapping("/deleteAll")
    public String deleteAll(){
        etudiantService.deleteAll();
        return "Deleted all records ";
    }




}
