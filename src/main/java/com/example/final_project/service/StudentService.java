package com.example.final_project.service;

import com.example.final_project.entity.StudentAccount;
import com.example.final_project.repository.StudentRepository;

import javax.ejb.Stateful;
import javax.inject.Inject;
import java.util.List;

@Stateful
public class StudentService {
    @Inject
    StudentRepository studentRepository;
    public List<StudentAccount> getAllStudents(){
        return studentRepository.findAll();
    }

    public StudentAccount deleteStudentById(int id) {return studentRepository.deleteById(id);}

    public StudentAccount changeNameById(int id, String name){return studentRepository.changeNameById(id, name);}

    public StudentAccount changeLastNameById(int id, String lastName){return studentRepository.changeLastNameById(id, lastName);}


    public  StudentAccount getStudentById(int id){return studentRepository.findById(id);}


    public StudentAccount getStudentByName(String name){return studentRepository.findByName(name);}

    public  StudentAccount getStudentByLastName(String lastname){return studentRepository.findByLastName(lastname);}

    public StudentAccount addNewStudent(int id, String firstName, String lastName, String userName,String password, double gpa){return studentRepository.addNewStudent(id, firstName, lastName,userName,password,gpa);}

}
