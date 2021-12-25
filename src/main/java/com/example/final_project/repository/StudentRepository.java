package com.example.final_project.repository;

import com.example.final_project.entity.StudentAccount;

import java.util.List;

public interface StudentRepository {
    List<StudentAccount> findAll();


    StudentAccount findById(int id);

    StudentAccount deleteById(int id);

    StudentAccount findByName(String firstName);

    StudentAccount findByLastName(String lastName);

    StudentAccount changeNameById(int id, String firstName);

    StudentAccount changeLastNameById(int id, String lastName);

    StudentAccount addNewStudent(int id, String name, String lastname, String userName,String password, double gpa);

}
