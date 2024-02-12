package com.example.springbootapp.Controller;
import com.example.springbootapp.dto.EmployeeDTO;
import com.example.springbootapp.dto.ResponseDTO;
import com.example.springbootapp.repo.EmployeeRepo;
import com.example.springbootapp.service.EmployeeService;
import com.example.springbootapp.util.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
            else if (res.equals("006")){
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
}
