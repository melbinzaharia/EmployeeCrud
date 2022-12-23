package hostbook.employeemanager.employeemanager.repo;

import hostbook.employeemanager.employeemanager.entity.Employee;
import hostbook.employeemanager.employeemanager.entity.Employee_;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.parsing.BeanEntry;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import java.util.List;

import static hostbook.employeemanager.employeemanager.entity.Employee_.ID;

@Transactional
@Repository
public class EmployeeCustomrepoImpl implements EmployeeCustomRepo{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Employee findEmployeeByEmpcode(String empc,Integer id) {
        CriteriaBuilder cb=entityManager.getCriteriaBuilder();
        CriteriaQuery cq=cb.createQuery(Employee.class);

        Root<Employee> employee=cq.from(Employee.class);


        Predicate employeeCodePredicate=cb.equal(employee.get("empcode"),empc);

        Predicate employeeIdPredicate=cb.notEqual(employee.get("id"),id);
        Predicate predicate = cb.and(employeeCodePredicate,employeeIdPredicate);
    cq.where(predicate);
        List<Employee> l=entityManager.createQuery(cq).getResultList();
        if(l.size()>0){
            return l.get(0);
        }

        return null ;
    }

}
