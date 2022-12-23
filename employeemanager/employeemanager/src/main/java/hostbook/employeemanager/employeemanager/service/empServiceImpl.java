package hostbook.employeemanager.employeemanager.service;

import hostbook.employeemanager.employeemanager.entity.Employee;
import hostbook.employeemanager.employeemanager.entity.EmployeeDto;
import hostbook.employeemanager.employeemanager.exception.EmpException;
import hostbook.employeemanager.employeemanager.repo.EmpRepo;
import hostbook.employeemanager.employeemanager.repo.EmployeeCustomRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import java.util.List;
import java.util.Optional;

@Service
public class empServiceImpl implements EmpService{
    @Autowired
    private EmployeeCustomRepo ecr;
    @Autowired
    private EmpRepo empRepo;
    @Autowired
    private ModelMapper modelMapper;



    @Override
    public Employee addEmployee(Employee emp,Errors errors) throws EmpException {
        Optional<Employee> existing = empRepo.findById(emp.getId());
        if(existing.isPresent()){
            System.out.println("customer is already present");
            throw new EmpException("Employee exist with similar id");
        }

        else{

            System.out.println("Employee details is saved");
            return empRepo.save(emp);
        }
    }
    @Override
    public Employee findEmployeeByEmpcode(String empCode,Integer id) {
       return ecr.findEmployeeByEmpcode(empCode,id);
    }
    @Override
    public Employee updateEmployee(Employee emp,Errors errors) throws EmpException {
        Employee em=null;
        Employee er;
        em=empRepo.findEmployeeByPhone(emp.getPhone());

        if(em!=null){
                    em=this.modelMapper.map(emp,Employee.class);
        }
        else {
            throw  new EmpException("Employee doesn't exist");
        }
        return  empRepo.save(em);
    }
    @Override
    public List<Employee> findAllEmployees() throws EmpException {
        return empRepo.findAll();
    }
    @Override
    public Employee deleteEmployeeById(Integer id) throws EmpException {
        Optional<Employee> existing = empRepo.findById(id);
        if(existing.isPresent()){
            System.out.println("Employee details deleted");
            empRepo.delete(existing.get());
        }
        else{
            throw new EmpException("Employee Doesn't exist with this id");
        }
        return existing.get();
    }
    @Override
    public Employee findEmployeeById(Integer id) throws EmpException {
        Optional<Employee> existing = empRepo.findById(id);
            if(existing.isPresent()){
                System.out.println("Employee details");
                return(existing.get());
            }
            else{
                throw new EmpException("Employee Doesn't exist with this id");
            }
    }
}
