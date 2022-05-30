package com.sadykov.ilshat.students_groups.controller;

import com.sadykov.ilshat.students_groups.dto.AddGroupRequestDto;
import com.sadykov.ilshat.students_groups.dto.AllGroupResponseDto;
import com.sadykov.ilshat.students_groups.dto.SingleGroupResponseDto;
import com.sadykov.ilshat.students_groups.dto.StudentResponseDto;
import com.sadykov.ilshat.students_groups.entity.Group;
import com.sadykov.ilshat.students_groups.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/groups")
public class GroupController {

    @Autowired
    GroupService groupService;

    @GetMapping("/")
    public List<AllGroupResponseDto> showAllGroup(){
        return groupService.getAllGroup();
    }

    @PostMapping("/add")
    public void addGroup(@RequestBody AddGroupRequestDto addGroupRequestDto){
        groupService.addGroup(addGroupRequestDto);
    }

    @GetMapping("/{id}")
    public SingleGroupResponseDto getGroup(@PathVariable("id") int id){
        Group group = groupService.getGroup(id);

        SingleGroupResponseDto singleGroupResponseDto = new SingleGroupResponseDto();
        singleGroupResponseDto.setId(group.getId());
        singleGroupResponseDto.setGroupName(group.getName());

        singleGroupResponseDto.setListStudent(group.getStudentList().stream()
                .map(student -> {
                    StudentResponseDto studentResponseDto = new StudentResponseDto();
                    studentResponseDto.setName(student.getName());
                    studentResponseDto.setId(student.getId());
                    studentResponseDto.setCreateAt(student.getLocalDate());
                    return studentResponseDto;
                }).collect(Collectors.toList()));
       return singleGroupResponseDto;
    }

}
