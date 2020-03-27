package com.example.demo_mongo.repository;

import com.example.demo_mongo.model.Etudiant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtudiantRepository extends MongoRepository <Etudiant, String> {

    public Etudiant findByFirstName(String firstname);
    public Etudiant findByAge(int age);


}
