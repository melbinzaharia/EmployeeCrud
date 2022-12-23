package hostbook.employeemanager.employeemanager.Validators;

import hostbook.employeemanager.employeemanager.controller.EmpController;
import hostbook.employeemanager.employeemanager.entity.Employee;
import hostbook.employeemanager.employeemanager.exception.EmpException;
import hostbook.employeemanager.employeemanager.repo.EmpRepo;
import hostbook.employeemanager.employeemanager.repo.EmployeeCustomRepo;
import hostbook.employeemanager.employeemanager.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ControllerAdvice;
@ControllerAdvice(assignableTypes = EmpController.class)
@Qualifier("validator")
public class EmployeeValidator implements Validator {
    @Autowired
    private EmpRepo empRepo;

    @Autowired
    private EmployeeCustomRepo ecr;

    @Autowired
    private EmpService empService;
    @Override
    public boolean supports(Class<?> clazz) {
        return Employee.class == clazz;
    }

    @Override
    public void validate(Object obj, Errors errors) {
        Employee e = (Employee) obj;
            if(ecr.findEmployeeByEmpcode(e.getEmpcode(),e.getId())!=null){
                    errors.rejectValue("empcode","empcode.exist","employee code is already present");
            }


        ValidationUtils.rejectIfEmpty(errors, "name", "name.empty","Name could not be blank");
        ValidationUtils.rejectIfEmpty(errors, "jobTitle", "jobTitle.empty","Jobtitle could not be blank");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "email.empty","email is empty");


    }
}
