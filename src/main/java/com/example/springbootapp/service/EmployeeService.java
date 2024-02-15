package com.example.springbootapp.service;

import com.example.springbootapp.dto.EmployeeDTO;
import com.example.springbootapp.entity.EmployeeEntity;
import com.example.springbootapp.repo.EmployeeRepo;
import com.example.springbootapp.util.VarList;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional

public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private ModelMapper modelMapper;

    public String saveEmployee(EmployeeDTO employeeDTO) {
        try {
            int empId = Integer.valueOf(Math.toIntExact(employeeDTO.getEmpId()));

            if (employeeRepo.existsById(empId)) {
                return VarList.RSP_DUPLICATED;
            } else {
                employeeRepo.save(modelMapper.map(employeeDTO, EmployeeEntity.class));
                return VarList.RSP_SUCCESS;
            }
        } catch (NumberFormatException e) {
            // Handle the case where the conversion to Long fails
            return VarList.RSP_NO_DATA_FOUND;
        } catch (Exception e) {
            // Handle other exceptions (e.g., database issues)
            return VarList.RSP_ERROR;
        }
    }

            //Update

    public String updateEmployee(EmployeeDTO employeeDTO) {
        if (employeeRepo.existsById(Integer.valueOf(Math.toIntExact(employeeDTO.getEmpId())))) {
            return VarList.RSP_SUCCESS;
        } else {
            employeeRepo.save(modelMapper.map(employeeDTO, EmployeeEntity.class));
            return VarList.RSP_NO_DATA_FOUND;
        }
    }

    //getAll
    public List<EmployeeDTO> getAllEmployee() {
        List<EmployeeEntity> employeeEntities = employeeRepo.findAll();
        return modelMapper.map(employeeEntities, new TypeToken<ArrayList<EmployeeDTO>>() {
        }.getType());
    }

    //Search

    public EmployeeDTO searchEmployee(int emp_Id) {
        if (employeeRepo.existsById(emp_Id)) {
            EmployeeEntity employee = employeeRepo.findById(emp_Id).orElse(null);
            return modelMapper.map(employee,EmployeeDTO.class);
        }
        else {
            return null;
        }
    }

    //delete
    public String deleteEmployee(int emp_id){
        if (employeeRepo.existsById(emp_id)){
            employeeRepo.deleteById(emp_id);
            return VarList.RSP_SUCCESS;
        }
        else {
            return VarList.RSP_NO_DATA_FOUND;
        }
    }
}
