package hostbook.employeemanager.employeemanager.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;


@ToString
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable=false)
    private Integer id;

    private String empcode;
    private String email;
    private String name;
    private String jobTitle;
    private String phone;
    private String ImageUrl;

    @OneToOne (    cascade = CascadeType.ALL,orphanRemoval = true)
    private Address address;



}
