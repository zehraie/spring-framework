package com.cydeo.bootstrap;

import com.cydeo.enums.Status;
import com.cydeo.model.*;
import com.cydeo.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

@Component
public class DataGenerator implements CommandLineRunner {

    private final PaymentRepository paymentRepository;
    private final MerchantRepository merchantRepository;

    private final CustomerRepository customerRepository;
    private final ItemRepository itemRepository;
    private final CardRepository cardRepository;

    public DataGenerator(PaymentRepository paymentRepository, MerchantRepository merchantRepository, CustomerRepository customerRepository, ItemRepository itemRepository, CardRepository cardRepository) {
        this.paymentRepository = paymentRepository;
        this.merchantRepository = merchantRepository;
        this.customerRepository = customerRepository;
        this.itemRepository = itemRepository;
        this.cardRepository = cardRepository;
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

        Customer customer1 = new Customer("mSmith", "Mike", "Smith", "msmith@gmail.com", "VA");
        payment1.setCustomer(customer1);
        payment2.setCustomer(customer1);

        customerRepository.save(customer1);

        payment1.setMerchant(merchant1);
        payment2.setMerchant(merchant1);
        payment3.setMerchant(merchant1);
        Item item1 = new Item("Milk", "M01");
        Item item2 = new Item("Juice", "S01");
        Item item3 = new Item("Coke", "T01");

        Card card1 = new Card();
        Card card2 = new Card();

        card1.setItemList(Arrays.asList(item1,item2,item3));
        card2.setItemList(Arrays.asList(item1,item3));
        itemRepository.save(item1);
        itemRepository.save(item2);
        itemRepository.save(item3);

        cardRepository.save(card1);
        cardRepository.save(card2);

        merchantRepository.save(merchant1);
        paymentRepository.save(payment1);
        paymentRepository.save(payment2);
        paymentRepository.save(payment3);



    }
}
