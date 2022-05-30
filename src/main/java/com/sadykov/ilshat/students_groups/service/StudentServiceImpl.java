package com.sadykov.ilshat.students_groups.service;

import com.sadykov.ilshat.students_groups.dto.AddStudentRequestDto;
import com.sadykov.ilshat.students_groups.entity.Group;
import com.sadykov.ilshat.students_groups.entity.Student;
import com.sadykov.ilshat.students_groups.repository.GroupRepository;
import com.sadykov.ilshat.students_groups.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    GroupRepository groupRepository;

    @Override
    public void addStudent(AddStudentRequestDto addStudentRequestDto) {

        Student student = new Student();

        Group group = groupRepository.findById(addStudentRequestDto.getGroupId())
                .orElseThrow(() ->{
                    throw new IllegalStateException("Group not exist");
                });

        student.setName(addStudentRequestDto.getName());
        student.setLocalDate(LocalDate.now());
        student.setGroup(group);

        studentRepository.save(student);
    }

    @Override
    public void deleteStudent(int id){
        Student student = studentRepository.findById(id)
                .orElseThrow(() ->{
                    throw new IllegalStateException("Student with id=" + id + " not exist");
                });
        studentRepository.delete(student);
    }
}
