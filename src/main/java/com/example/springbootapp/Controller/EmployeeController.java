package com.example.springbootapp.Controller;
import com.example.springbootapp.dto.EmployeeDTO;
import com.example.springbootapp.dto.ResponseDTO;
import com.example.springbootapp.repo.EmployeeRepo;
import com.example.springbootapp.service.EmployeeService;
import com.example.springbootapp.util.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("api/v1/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    ResponseDTO responseDTO;

    @PostMapping("/saveEmployee")
    public ResponseEntity saveEmployee(@RequestBody EmployeeDTO employeeDTO){
        try {
            String res=employeeService.saveEmployee(employeeDTO);
            if (res.equals("00")){
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMassage(VarList.RSP_SUCCESS);
                responseDTO.setContact(employeeDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            }
            else if (res.equals("06")){
                responseDTO.setCode(VarList.RSP_DUPLICATED);
                responseDTO.setMassage("Employee registered");
                responseDTO.setContact(employeeDTO);
                return new ResponseEntity(responseDTO,HttpStatus.BAD_REQUEST);

            }
            else {
                responseDTO.setCode(VarList.RSP_FAIL);
                responseDTO.setMassage("Error");
                responseDTO.setContact(null);
                return new ResponseEntity(responseDTO,HttpStatus.BAD_REQUEST);
            }

        }
        catch (Exception e){
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMassage("Error");
            responseDTO.setContact(null);
            return new ResponseEntity(responseDTO,HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/UpdateEmployee")
    public ResponseEntity updateEmployee(@RequestBody EmployeeDTO employeeDTO){
        try {
            String res=employeeService.saveEmployee(employeeDTO);
            if (res.equals("00")){
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMassage(VarList.RSP_SUCCESS);
                responseDTO.setContact(employeeDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            }
            else if (res.equals("01")){
                responseDTO.setCode(VarList.RSP_DUPLICATED);
                responseDTO.setMassage("Employee registered");
                responseDTO.setContact(employeeDTO);
                return new ResponseEntity(responseDTO,HttpStatus.BAD_REQUEST);

            }
            else {
                responseDTO.setCode(VarList.RSP_FAIL);
                responseDTO.setMassage("Error");
                responseDTO.setContact(null);
                return new ResponseEntity(responseDTO,HttpStatus.BAD_REQUEST);
            }

        }
        catch (Exception e){
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMassage("Error");
            responseDTO.setContact(null);
            return new ResponseEntity(responseDTO,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAllEmployee")
    public ResponseEntity getAllEmployee(){
        try {
            List<EmployeeDTO> employeeDTOS=employeeService.getAllEmployee();
            responseDTO.setCode(VarList.RSP_SUCCESS);
            responseDTO.setMassage("Success");
            responseDTO.setContact(employeeDTOS);
            return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
        }
        catch (Exception x){
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMassage(x.getMessage());
            responseDTO.setContact(null);
            return new ResponseEntity(responseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @GetMapping("/searchEmployee")
    public ResponseEntity searchEmployee(@PathVariable int emp_id){
        try {
            EmployeeDTO employeeDTOS=employeeService.searchEmployee(emp_id);
            responseDTO.setCode(VarList.RSP_SUCCESS);
            responseDTO.setMassage("Success");
            responseDTO.setContact(employeeDTOS);
            return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
        }
        catch (Exception x){
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMassage(x.getMessage());
            responseDTO.setContact(null);
            return new ResponseEntity(responseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/DeleteEmployee/{emp_id}")
    public ResponseEntity DeleteEmployee(@PathVariable int emp_id){
        try {
            String res = employeeService.deleteEmployee(emp_id);

            if (res.equals("00")) {
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMassage("Success");
                responseDTO.setContact(null);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            }else {
                responseDTO.setCode(VarList.RSP_NO_DATA_FOUND);
                responseDTO.setMassage("No Employe this iD");
                responseDTO.setContact(null);
                return new ResponseEntity(responseDTO,HttpStatus.BAD_REQUEST);
            }
        }
        catch (Exception x){
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMassage(x.getMessage());
            responseDTO.setContact(x);
            return new ResponseEntity(responseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
