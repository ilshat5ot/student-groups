package com.sadykov.ilshat.students_groups.service;

import com.sadykov.ilshat.students_groups.dto.AddStudentRequestDto;

public interface StudentService {
    void addStudent(AddStudentRequestDto addStudentRequestDto);
    void deleteStudent(int id);
}

