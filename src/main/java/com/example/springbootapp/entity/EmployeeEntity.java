package com.example.springbootapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeEntity {
    private String EmpId;
    private String EmpName;
    private String EmpAddress;
    private String EmpMobileNumber;
}
