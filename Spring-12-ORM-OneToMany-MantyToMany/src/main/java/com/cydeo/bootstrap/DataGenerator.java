package com.cydeo.bootstrap;

import com.cydeo.enums.Status;
import com.cydeo.model.Merchant;
import com.cydeo.model.Payment;
import com.cydeo.model.PaymentDetail;
import com.cydeo.repository.MerchantRepository;
import com.cydeo.repository.PaymentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
@Component
public class DataGenerator implements CommandLineRunner {

    private final PaymentRepository paymentRepository;
    private final MerchantRepository merchantRepository;

    public DataGenerator(PaymentRepository paymentRepository, MerchantRepository merchantRepository) {
        this.paymentRepository = paymentRepository;
        this.merchantRepository = merchantRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Payment payment1= new Payment(LocalDate.of(2022,4,13),new BigDecimal(50000), Status.SUCCESS);
        PaymentDetail paymentDetail1= new PaymentDetail(new BigDecimal("40000"),new BigDecimal("60000"),LocalDate.of(2022,4,13));

        payment1.setPaymentDetail(paymentDetail1);

        Payment payment2 = new Payment(LocalDate.of(2022,4,25),new BigDecimal("100000"), Status.FAILURE);
        PaymentDetail paymentDetail2 = new PaymentDetail(new BigDecimal("90000"),new BigDecimal("5000"),LocalDate.of(2022,4,29));

        payment2.setPaymentDetail(paymentDetail2);


        Payment payment3 = new Payment(LocalDate.of(2023,3,13),new BigDecimal("160000"), Status.SUCCESS);
        PaymentDetail paymentDetail3 = new PaymentDetail(new BigDecimal("190000"),new BigDecimal("555000"),LocalDate.of(2023,3,13));

        payment3.setPaymentDetail(paymentDetail3);


        Merchant merchant1 = new Merchant("AmazonSubMerchant","M123",new BigDecimal("0.25"),new BigDecimal("3.25"),5);
        // i ahve one merchant and three payments

        payment1.setMerchant(merchant1);
        payment2.setMerchant(merchant1);
        payment3.setMerchant(merchant1);
        paymentRepository.save(payment1);
        paymentRepository.save(payment2);
        paymentRepository.save(payment3);

        merchantRepository.save(merchant1);

    }
}
