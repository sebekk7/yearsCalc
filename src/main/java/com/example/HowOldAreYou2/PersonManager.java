package com.example.HowOldAreYou2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonManager {

    // private EntityManager entityManager;
    private final PersonRepo personRepo;

    private final List<Person> personList = new ArrayList<>();

    @Autowired
    public PersonManager(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    Person person1 = new Person("Joanna", 1989);


    @EventListener(ApplicationReadyEvent.class)
    public void fillDb() {
//        personRepo.save(new Person());
    }

//
//    public void add(Person p) {
//
//        personList.add(new Person(name, year));
//
//    }


}
