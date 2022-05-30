package com.sadykov.ilshat.students_groups.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SingleGroupResponseDto {

    Integer id;
    String groupName;
    List<StudentResponseDto> listStudent;

}
