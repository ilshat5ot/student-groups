package com.sadykov.ilshat.students_groups.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponseDto {

    Integer id;
    String name;
    LocalDate createAt;

}
