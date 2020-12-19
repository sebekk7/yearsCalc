package com.example.HowOldAreYou2.service;

import com.example.HowOldAreYou2.entities.Person;
import com.example.HowOldAreYou2.repositories.PersonRepo;
import net.bytebuddy.implementation.auxiliary.AuxiliaryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    PersonRepo personRepo;

    @Autowired
    public PersonService(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    public void deletePerson(Person person, PersonRepo personRepo){
        personRepo.delete(person);
    }

}
