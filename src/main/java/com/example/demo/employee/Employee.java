package com.example.demo.employee;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity(name = "Employee")
@Table(name = "employee")
public class Employee {

    @Id
    @SequenceGenerator(
            name = "employee_sequence",
            sequenceName = "employee_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "employee_sequence"
    )
    @Column(name = "id")
//    columnDefinition = "SERIAL"
    private long id;

    @Column(name = "name",
            nullable = false,
            columnDefinition = "TEXT")
    private String name;

    @Column(name = "gender",
            nullable = false,
            columnDefinition = "VARCHAR(6)")
    private Gender gender;

    @Column(name = "date_of_birth",
            nullable = false,
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Date DateOfBirth;

    @Column(name = "address",
            nullable = false,
            columnDefinition = "TEXT")
    private String address;


    public Employee(String name, Gender gender, Date dateOfBirth, String address) {
        this.name = name;
        this.gender = gender;
        DateOfBirth = dateOfBirth;
        this.address = address;
    }
}
