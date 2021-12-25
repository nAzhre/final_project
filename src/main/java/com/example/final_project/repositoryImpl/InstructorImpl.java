package com.example.final_project.repositoryImpl;

import com.example.final_project.EntityManager;
import com.example.final_project.entity.InstructorAccount;
import com.example.final_project.repository.InstructorRepository;

import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class InstructorImpl implements InstructorRepository {
    @Inject
    EntityManager em;

    @Override
    public List<InstructorAccount> findAll() {
        javax.persistence.EntityManager entityManager = em.manager();
        try {
            Query query = entityManager.createQuery("SELECT i FROM InstructorAccount i");
            List<InstructorAccount> result = query.getResultList();
            return result;
        } catch (NoResultException e){
            return null;
        }
    }

    @Override
    public InstructorAccount findById(int id) {
        javax.persistence.EntityManager entityManager = em.manager();
        try {
            String sql = String.format("SELECT b FROM InstructorAccount b WHERE b.id = %d", id);
            Query query = entityManager.createQuery(sql);
            InstructorAccount result = (InstructorAccount) query.getSingleResult();
            return result;
        } catch (NoResultException e){
            return null;
        }
    }

    @Override
    public InstructorAccount deleteById(int id) {
        javax.persistence.EntityManager entityManager = em.manager();
        try {
            InstructorAccount instructorAccount = entityManager.find(InstructorAccount.class, id);
            entityManager.remove(instructorAccount);
            return instructorAccount;
        } catch (NoResultException e){
            return null;
        }
    }

    @Override
    public InstructorAccount findByFirstName(String firstName) {
        javax.persistence.EntityManager entityManager = em.manager();
        try {
            String sql = String.format("SELECT b FROM InstructorAccount b WHERE b.firstName = '%s'", firstName);
            Query query = entityManager.createQuery(sql);
            InstructorAccount result = (InstructorAccount) query.getSingleResult();
            return result;
        } catch (NoResultException e){
            return null;
        }
    }


    @Override
    public InstructorAccount findByLastName(String lastname) {
        javax.persistence.EntityManager entityManager = em.manager();
        try {
            String sql = String.format("SELECT b FROM InstructorAccount b WHERE b.lastName = '%s'", lastname);
            Query query = entityManager.createQuery(sql);
            InstructorAccount result = (InstructorAccount) query.getSingleResult();
            return result;
        } catch (NoResultException e){
            return null;
        }
    }

    @Override
    public InstructorAccount findByUserName(String userName) {
        javax.persistence.EntityManager entityManager = em.manager();
        try {
            String sql = String.format("SELECT b FROM InstructorAccount b WHERE b.userName = '%s'", userName);
            Query query = entityManager.createQuery(sql);
            InstructorAccount result = (InstructorAccount) query.getSingleResult();
            return result;
        } catch (NoResultException e){
            return null;
        }
    }

    @Override
    public InstructorAccount findByEmail(String email) {
        javax.persistence.EntityManager entityManager = em.manager();
        try {
            String sql = String.format("SELECT b FROM InstructorAccount b WHERE b.email = '%s'", email);
            Query query = entityManager.createQuery(sql);
            InstructorAccount result = (InstructorAccount) query.getSingleResult();
            return result;
        } catch (NoResultException e){
            return null;
        }
    }

    @Override
    public InstructorAccount changeById(int id, String firstName, String lastName) {
        javax.persistence.EntityManager entityManager = em.manager();
        try {
            InstructorAccount instructorAccount = entityManager.find(InstructorAccount.class, id);
            instructorAccount.setFirstName(firstName);
            instructorAccount.setLastName(lastName);
            entityManager.persist(instructorAccount);
            return instructorAccount;
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public InstructorAccount changeFirstNameById(int id, String firstName) {
        javax.persistence.EntityManager entityManager = em.manager();
        try {
            InstructorAccount instructorAccount = entityManager.find(InstructorAccount.class, InstructorAccount.class);
            instructorAccount.setFirstName(firstName);
            entityManager.persist(instructorAccount);
            return instructorAccount;
        } catch (NoResultException e) {
            return null;
        }
    }



    @Override
    public InstructorAccount changeLastNameById(int id, String lastName) {
        javax.persistence.EntityManager entityManager = em.manager();
        try {
            InstructorAccount instructorAccount = entityManager.find(InstructorAccount.class, id);
            instructorAccount.setLastName(lastName);
            entityManager.persist(instructorAccount);
            return instructorAccount;
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public InstructorAccount addNewInstructor(int id, String firstName, String lastName, String userName, String email) {
        javax.persistence.EntityManager entityManager = em.manager();
        try {
            InstructorAccount instructorAccount = new InstructorAccount((int) id, firstName, lastName, userName, email);
            entityManager.persist(instructorAccount);;
            return instructorAccount;
        } catch (NoResultException e){
            return null;
        }
    }

}
