package com.example.HowOldAreYou2.repositories;

import com.example.HowOldAreYou2.entities.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepo extends CrudRepository<Person, Long> {

}
