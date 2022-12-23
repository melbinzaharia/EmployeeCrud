package hostbook.employeemanager.employeemanager.repo;


import hostbook.employeemanager.employeemanager.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

public interface EmployeeCustomRepo {


    Employee findEmployeeByEmpcode(String empc,Integer id) ;

}
