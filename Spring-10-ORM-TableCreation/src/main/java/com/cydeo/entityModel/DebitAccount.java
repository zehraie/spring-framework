package com.cydeo.entityModel;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
@Entity  // this create table
@Table(name="DebitAccountTtable")
public class DebitAccount extends Account{

    private BigDecimal overDraftFee;
}
