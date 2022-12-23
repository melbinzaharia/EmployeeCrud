package hostbook.employeemanager.employeemanager.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Address.class)
public abstract class Address_ {

	public static volatile SingularAttribute<Address, String> country;
	public static volatile SingularAttribute<Address, String> pincode;
	public static volatile SingularAttribute<Address, String> city;
	public static volatile SingularAttribute<Address, Integer> addrId;
	public static volatile SingularAttribute<Address, String> state;

	public static final String COUNTRY = "country";
	public static final String PINCODE = "pincode";
	public static final String CITY = "city";
	public static final String ADDR_ID = "addrId";
	public static final String STATE = "state";

}

