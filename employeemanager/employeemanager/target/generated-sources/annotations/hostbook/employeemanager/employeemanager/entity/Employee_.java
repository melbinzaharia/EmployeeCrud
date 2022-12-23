package hostbook.employeemanager.employeemanager.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Employee.class)
public abstract class Employee_ {

	public static volatile SingularAttribute<Employee, Address> address;
	public static volatile SingularAttribute<Employee, String> phone;
	public static volatile SingularAttribute<Employee, String> jobTitle;
	public static volatile SingularAttribute<Employee, String> name;
	public static volatile SingularAttribute<Employee, String> ImageUrl;
	public static volatile SingularAttribute<Employee, Integer> id;
	public static volatile SingularAttribute<Employee, String> empcode;
	public static volatile SingularAttribute<Employee, String> email;

	public static final String ADDRESS = "address";
	public static final String PHONE = "phone";
	public static final String JOB_TITLE = "jobTitle";
	public static final String NAME = "name";
	public static final String IMAGE_URL = "ImageUrl";
	public static final String ID = "id";
	public static final String EMPCODE = "empcode";
	public static final String EMAIL = "email";

}

