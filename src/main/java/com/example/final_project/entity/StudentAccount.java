package com.example.final_project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "studentAccounts")
@NoArgsConstructor
@AllArgsConstructor
public class StudentAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Column(name = "\"firstName\"")
    private String firstName;

    @NotNull
    @Column(name = "\"lastName\"")
    private String lastName;

    @NotNull
    @Column(name = "\"userName\"")
    private String userName;

    @NotNull
    @Column(name = "\"password\"")
    private String password;

    @NotNull
    @Column(name = "\"gpa\"")
    private double gpa;

//    @NotNull
//    @Column(name = "birthDate")
//    private LocalDate birthDate;
//
//    @NotNull
//    @Column(name = "gpa")
//    private Double gpa;

//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public LocalDate getBirthDate() {
//        return birthDate;
//    }
//
//    public void setBirthDate(LocalDate birthDate) {
//        this.birthDate = birthDate;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
}
