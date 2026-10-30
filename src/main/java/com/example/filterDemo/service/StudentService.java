package com.example.filterDemo.service;

import com.example.filterDemo.dto.Student;
import com.example.filterDemo.dto.StudentResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    public  StudentResponseDTO createStudent(Student s){
        StudentResponseDTO responsedto=new StudentResponseDTO();
        responsedto.setAge(s.getAge());
        responsedto.setName(s.getName());
        return responsedto;
    }
}
