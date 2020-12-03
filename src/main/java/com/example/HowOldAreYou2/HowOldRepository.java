package com.example.HowOldAreYou2;

import org.springframework.stereotype.Service;

@Service
public class HowOldRepository {

    HowOld howOld = new HowOld();

    public String yearsCalc(){
       return String.valueOf(howOld.getLocalDate().getYear() - howOld.getYearOfBirth());
    }

}
