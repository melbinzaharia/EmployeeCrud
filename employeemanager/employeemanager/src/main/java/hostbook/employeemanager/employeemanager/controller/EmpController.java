package hostbook.employeemanager.employeemanager.controller;


import hostbook.employeemanager.employeemanager.entity.Employee;
import hostbook.employeemanager.employeemanager.exception.EmpException;
import hostbook.employeemanager.employeemanager.repo.EmpRepo;
import hostbook.employeemanager.employeemanager.repo.EmployeeCustomRepo;
import hostbook.employeemanager.employeemanager.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.bind.validation.ValidationErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EmpController {
    @Autowired
    @Qualifier("validator")
    private Validator EmployeeValidator;
    @Autowired
    private EmpService empService;

    @Autowired
    private EmployeeCustomRepo ecr;

    @Autowired
    private EmpRepo empRepo;

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(EmployeeValidator);
    }

    @PostMapping("/register")
    public ResponseEntity<?> addEmployee(@Valid  @RequestBody Employee emp,Errors errors) throws EmpException{


        if (errors.hasErrors()) {
            return new ResponseEntity<>( errors.getAllErrors(), HttpStatus.OK);
        }
        Employee newEmp =empService.addEmployee(emp,  errors);
        return new ResponseEntity<>(newEmp, HttpStatus.CREATED);
    }

    @PutMapping("/update")
public ResponseEntity<?> updateEmployee(@Valid  @RequestBody Employee emp,Errors errors) throws EmpException{
Employee er=ecr.findEmployeeByEmpcode(emp.getEmpcode(), emp.getId());

        if (errors.hasErrors()) {
            return new ResponseEntity<>( errors.getAllErrors(), HttpStatus.OK);
        }
        Employee newEmp =empService.updateEmployee(emp,  errors);
        return new ResponseEntity<>(newEmp, HttpStatus.CREATED);




}

@DeleteMapping("/delete/{id}")
public ResponseEntity<Employee> deleteEmployeeById(@PathVariable Integer id) throws EmpException{
        Employee deleteEmployee = empService.deleteEmployeeById(id);
        return new ResponseEntity<Employee>(deleteEmployee,HttpStatus.OK);
}

@GetMapping("/find/{id}")
public ResponseEntity<Employee> findEmployeeById(@PathVariable Integer id) throws EmpException{
        Employee emp=empService.findEmployeeById(id);

    return new ResponseEntity<>(emp,HttpStatus.OK);
}
    @GetMapping("/findAll")
public  ResponseEntity<List<Employee>> findAllEmployees() throws  EmpException{
        List<Employee> employees=empService.findAllEmployees();
        return new ResponseEntity<List<Employee>>(employees,HttpStatus.OK);
}
}
