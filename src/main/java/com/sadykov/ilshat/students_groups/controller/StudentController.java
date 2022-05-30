package com.sadykov.ilshat.students_groups.controller;

import com.sadykov.ilshat.students_groups.dto.AddStudentRequestDto;
import com.sadykov.ilshat.students_groups.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/add")
    public void addGroup(@RequestBody AddStudentRequestDto addStudentRequestDto){
        studentService.addStudent(addStudentRequestDto);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable("id") int id){
        studentService.deleteStudent(id);
    }


}
