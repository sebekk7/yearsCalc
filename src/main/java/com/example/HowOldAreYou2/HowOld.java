package com.example.HowOldAreYou2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HowOld {
    private int yearOfBirth;
    private LocalDate localDate;
}
