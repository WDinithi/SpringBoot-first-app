package com.example.springbootapp.service;

import com.example.springbootapp.dto.EmployeeDTO;
import com.example.springbootapp.entity.EmployeeEntity;
import com.example.springbootapp.repo.EmployeeRepo;
import com.example.springbootapp.util.VarList;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional

public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private ModelMapper modelMapper;

    public String saveEmployee(EmployeeDTO employeeDTO){
        if (employeeRepo.existsById(Integer.valueOf(employeeDTO.getEmpId()))){
            return VarList.RSP_DUPLICATED;
        }
        else {
            employeeRepo.save(modelMapper.map(employeeDTO, EmployeeEntity.class));
            return VarList.RSP_SUCCESS;
        }

    }

    //Update

    public String updateEmployee(EmployeeDTO employeeDTO){
        if (employeeRepo.existsById(Integer.valueOf(employeeDTO.getEmpId()))){
            return VarList.RSP_SUCCESS;
        }
        else {
            employeeRepo.save(modelMapper.map(employeeDTO, EmployeeEntity.class));
            return VarList.RSP_NO_DATA_FOUND;
        }
    }
}
