package com.example.final_project.service;

import com.example.final_project.entity.InstructorAccount;
import com.example.final_project.repository.InstructorRepository;

import javax.ejb.Stateful;
import javax.inject.Inject;
import java.util.List;

@Stateful
public class InstructorService {
    @Inject
    InstructorRepository instructorRepository;

    public List<InstructorAccount> getAllInstructors(){
        return instructorRepository.findAll();
    }

    public InstructorAccount  deleteInstructorById(int id) {return instructorRepository.deleteById(id);}

    public InstructorAccount changeFirstNameById(int id, String firstName){return instructorRepository.changeFirstNameById(id, firstName);}

    public InstructorAccount changeLastNameById(int id, String lastName){return instructorRepository.changeLastNameById(id, lastName);}

    public  InstructorAccount getInstructorById(int id){return instructorRepository.findById(id);}


    public InstructorAccount getInstructorByFirstName(String firstName){return instructorRepository.findByFirstName(firstName);}

    public  InstructorAccount getInstructorByLastName(String lastName){return instructorRepository.findByLastName(lastName);}

    public  InstructorAccount getInstructorByEmail(String email){return instructorRepository.findByEmail(email);}

    public InstructorAccount changeById(int id, String firstName, String lastName){return instructorRepository.changeById(id, firstName, lastName);}

    public InstructorAccount addNewInstructor(int id, String firstName, String lastName, String userName, String email){return instructorRepository.addNewInstructor(id, firstName, lastName,userName, email);}

}
