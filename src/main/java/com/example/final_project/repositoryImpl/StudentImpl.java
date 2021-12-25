package com.example.final_project.repositoryImpl;

import com.example.final_project.EntityManager;
import com.example.final_project.entity.InstructorAccount;
import com.example.final_project.entity.StudentAccount;
import com.example.final_project.repository.StudentRepository;

import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

public class StudentImpl implements StudentRepository {
    @Inject
    EntityManager em;

    @Override
    public List<StudentAccount> findAll() {
        javax.persistence.EntityManager entityManager = em.manager();
        try {
            Query query = entityManager.createQuery("SELECT a FROM StudentAccount a");
            List<StudentAccount> result = query.getResultList();
            return result;
        } catch (NoResultException e){
            return null;
        }
    }

    @Override
    public StudentAccount findById(int id) {
        javax.persistence.EntityManager entityManager = em.manager();
        try {
            String sql = String.format("SELECT b FROM StudentAccount b WHERE b.id = %d", id);
            Query query = entityManager.createQuery(sql);
            StudentAccount result = (StudentAccount) query.getSingleResult();
            return result;
        } catch (NoResultException e){
            return null;
        }
    }

    @Override
    public StudentAccount deleteById(int id) {
        return null;
    }

    @Override
    public StudentAccount findByName(String firstName) {
        return null;
    }

    @Override
    public StudentAccount findByLastName(String lastName) {
        return null;
    }

    @Override
    public StudentAccount changeNameById(int id, String firstName) {
        return null;
    }

    @Override
    public StudentAccount changeLastNameById(int id, String lastname) {
        return null;
    }

    @Override
    public StudentAccount addNewStudent(int id, String name, String lastname, int age, double gpa) {
        return null;
    }
}
