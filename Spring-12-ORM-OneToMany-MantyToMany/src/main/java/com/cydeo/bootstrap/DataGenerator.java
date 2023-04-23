package com.cydeo.bootstrap;

import com.cydeo.enums.Status;
import com.cydeo.model.Payment;
import com.cydeo.model.PaymentDetail;
import com.cydeo.repository.PaymentRepository;
import org.springframework.boot.CommandLineRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class DataGenerator implements CommandLineRunner {

    private final PaymentRepository paymentRepository;

    public DataGenerator(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Payment payment1= new Payment(LocalDate.of(2022,4,13),new BigDecimal(50000), Status.SUCCESS);
        PaymentDetail paymentDetail1= new PaymentDetail(new BigDecimal("40000"),new BigDecimal("60000"),LocalDate.of(2022,4,13));

        payment1.setPaymentDetail(paymentDetail1);

        Payment payment2 = new Payment(LocalDate.of(2022,4,25),new BigDecimal("100000"), Status.FAILURE);
        PaymentDetail paymentDetail2 = new PaymentDetail(new BigDecimal("90000"),new BigDecimal("5000"),LocalDate.of(2022,4,29));

        payment2.setPaymentDetail(paymentDetail2);

        paymentRepository.save(payment1);
        paymentRepository.save(payment2);

    }
}
