package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "regions")
@Data
@NoArgsConstructor
public class Region extends BaseEntity{
    public Region(String region, String country) {
        this.region = region;
        this.country = country;
    }

    private String region;
    private String country;
    @OneToOne(mappedBy = "region")
    private Employee employee;// create region column in Employee table

    //we do not need region REp because cascading ile persit oluyor save oluyor yani


}
