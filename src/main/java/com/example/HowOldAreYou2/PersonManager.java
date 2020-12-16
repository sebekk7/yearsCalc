package com.example.HowOldAreYou2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class PersonManager {

    // private EntityManager entityManager;
//    private final PersonRepo personRepo;
//
//
//    @Autowired
//    public PersonManager(PersonRepo personRepo) {
//        this.personRepo = personRepo;
//    }


//    Person person = new Person("Adam", 2000);


//    @EventListener(ApplicationReadyEvent.class)
//    public void fillDb() {
//       personRepo.save(new Person(person.getName(), person.getYearOfBirth()));
//    }


}
