package com.example.springbootapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Employee")
public class EmployeeDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long EmpId;  // Assuming EmpId is of type Long for auto-generated IDs
    private String EmpName;
    private String EmpAddress;
    private String EmpMobileNumber;
}
