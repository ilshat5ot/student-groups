package com.sadykov.ilshat.students_groups.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AllGroupResponseDto {

    Integer id;
    String name;
    int studentQuantity;
}
