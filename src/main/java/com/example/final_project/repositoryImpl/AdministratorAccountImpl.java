package com.example.final_project.repositoryImpl;

import com.example.final_project.EntityManager;
import com.example.final_project.entity.AdministratorAccount;
import com.example.final_project.entity.InstructorAccount;
import com.example.final_project.repository.AdministratorAccountRepository;

import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.awt.*;

public class AdministratorAccountImpl implements AdministratorAccountRepository {
    @Inject
    EntityManager em;


    @Override
    public AdministratorAccount findById(int id) {
        javax.persistence.EntityManager entityManager = em.manager();
        try {
            String sql = String.format("SELECT u FROM AdministratorAccount u WHERE id = %d", id);
            Query query = entityManager.createQuery(sql);
            AdministratorAccount result = (AdministratorAccount) query.getSingleResult();
            return result;
        } catch (NoResultException e){
            return null;
        }
    }

    @Override
    public AdministratorAccount authenticate(String userName, String password) {
        javax.persistence.EntityManager entityManager = em.manager();
        try {
            String sql = String.format("SELECT u FROM AdministratorAccount u WHERE u.userName = '%s'  AND u.password = '%s'", userName, password);
            Query query = entityManager.createQuery(sql);
            AdministratorAccount result = (AdministratorAccount) query.getSingleResult();
            return result;
        } catch (NoResultException e){
            return null;
        }
    }

    @Override
    public AdministratorAccount deleteById(int id) {
        javax.persistence.EntityManager entityManager = em.manager();
        try {
            AdministratorAccount user = entityManager.find(AdministratorAccount.class, id);
            entityManager.getTransaction().begin();
            entityManager.remove(user);
            entityManager.getTransaction().commit();
            return user;
        } catch (NoResultException e){
            return null;
        }
    }

    @Override
    public AdministratorAccount findByUserName(String userName) {
        javax.persistence.EntityManager entityManager = em.manager();
        try {
            String sql = String.format("SELECT b FROM AdministratorAccount b WHERE b.userName = '%s'", userName);
            Query query = entityManager.createQuery(sql);
            AdministratorAccount results = (AdministratorAccount) query.getSingleResult();
            return results;
        } catch (NoResultException e){
            return null;
        }
    }

    @Override
    public AdministratorAccount updatePasswordById(int id, String password) {
        return null;
    }

}
