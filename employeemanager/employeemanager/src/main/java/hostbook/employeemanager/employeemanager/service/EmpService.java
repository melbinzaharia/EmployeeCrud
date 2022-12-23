package hostbook.employeemanager.employeemanager.service;

import hostbook.employeemanager.employeemanager.entity.Employee;
import hostbook.employeemanager.employeemanager.exception.EmpException;
import org.springframework.validation.Errors;

import java.util.List;

public interface EmpService {


    Employee addEmployee(Employee emp, Errors errors) throws EmpException;



    Employee findEmployeeByEmpcode(String integer,Integer id);

    public  Employee updateEmployee(Employee emp, Errors errors) throws EmpException;
    public List<Employee> findAllEmployees() throws EmpException;
    public Employee deleteEmployeeById(Integer id) throws EmpException;

    public Employee findEmployeeById(Integer id) throws EmpException;
}
