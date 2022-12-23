package hostbook.employeemanager.employeemanager.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Address {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int addrId;
private  String city;

    private  String state;
    private  String country;
    private  String pincode;




}
