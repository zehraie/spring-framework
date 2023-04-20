package com.cydeo.entityModel;

import com.cydeo.enums.Gender;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;


@Entity
@Table(name="students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="studentFirstName",length =30)
    private String firstName; //first_name

    @Column(name="studentLastName")
    private String lastName;
    private String email;
@Transient
    private String city;
@Column(columnDefinition = "DATE")
private LocalDate birthdate;
@Column(columnDefinition="Time" )
private LocalTime birthTime;
@Column(columnDefinition="TIMESTAMP" )

private LocalDate birthDateTime;
// gender int, if you have enum give this but we need String so put this annoation
    // then you put it and gives varchar(255)
    @Enumerated(EnumType.STRING)
private Gender gender;

}
