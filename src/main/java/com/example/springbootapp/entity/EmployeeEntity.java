package com.example.springbootapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class EmployeeEntity {
    @Id
    private String EmpId;
    private String EmpName;
    private String EmpAddress;
    private String EmpMobileNumber;
}
