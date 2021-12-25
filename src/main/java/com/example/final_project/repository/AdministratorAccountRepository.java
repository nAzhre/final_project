package com.example.final_project.repository;

import com.example.final_project.entity.AdministratorAccount;

import java.awt.*;

public interface AdministratorAccountRepository {
    AdministratorAccount findById(int id);
    AdministratorAccount authenticate(String userName, String password);
    AdministratorAccount deleteById(int id);
    AdministratorAccount updatePasswordById(int id, String password);
    AdministratorAccount findByUserName(String userName);
}
