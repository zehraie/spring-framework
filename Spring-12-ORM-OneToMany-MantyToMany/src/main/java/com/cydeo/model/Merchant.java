package com.cydeo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name="merchants")
@Data
@NoArgsConstructor
public class Merchant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String code;
    private BigDecimal transactions;
    private BigDecimal commisionRate;
    private Integer payoutDelayCount;

    public Merchant(String name, String code, BigDecimal transactions, BigDecimal commisionRate, Integer payoutDelayCount) {
        this.name = name;
        this.code = code;
        this.transactions = transactions;
        this.commisionRate = commisionRate;
        this.payoutDelayCount = payoutDelayCount;
    }

    // in oneToMany relashi ownershhip belongs to many side
    @OneToMany(mappedBy = "merchant")   // collenction of object we need
    private List<Payment> paymentList;
}
