package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name="COURSES")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="NAME")
    private String name;
    @Column(name="CATEGORY")
    private String category;
    @Column(name="RATING")
    private int rating;
    @Column(name="DESCRIPTION")
    private String description;

}
