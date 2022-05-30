package com.sadykov.ilshat.students_groups.service;

import com.sadykov.ilshat.students_groups.dto.AddGroupRequestDto;
import com.sadykov.ilshat.students_groups.dto.AllGroupResponseDto;
import com.sadykov.ilshat.students_groups.entity.Group;

import java.util.List;

public interface GroupService {
    void addGroup(AddGroupRequestDto addGroupRequestDto);

    Group getGroup(int id);

    List<AllGroupResponseDto> getAllGroup();
}
