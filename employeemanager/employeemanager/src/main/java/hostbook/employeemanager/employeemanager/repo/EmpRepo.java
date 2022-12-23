package hostbook.employeemanager.employeemanager.repo;

import hostbook.employeemanager.employeemanager.entity.Employee;
import hostbook.employeemanager.employeemanager.exception.EmpException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.validation.Errors;

import java.util.Optional;

@Repository
public interface EmpRepo extends JpaRepository<Employee,Integer> {

//    @Query("from Employee as e where e.empcode =:empc and e.id=:Id")



    Employee findEmployeeById(Integer integer) throws EmpException;

    Employee findEmployeeByPhone(String mobile) throws EmpException;



}
