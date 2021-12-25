package com.example.final_project.repository;

import com.example.final_project.entity.InstructorAccount;

import java.util.List;

public interface InstructorRepository {
    List<InstructorAccount> findAll();

    InstructorAccount findById(int id);

    InstructorAccount deleteById(int id);

    InstructorAccount findByFirstName(String firstName);

    InstructorAccount findByLastName(String lastName);

    InstructorAccount findByUserName (String userName);
    InstructorAccount findByEmail (String email);


    InstructorAccount changeById(int id, String firstName, String lastName);

    InstructorAccount changeFirstNameById(int id, String firstName);

    InstructorAccount changeLastNameById(int id, String lastName);

    InstructorAccount addNewInstructor(int id, String firstName, String lastName, String userName,String email );
}
