package com.ironhack.labjavaintrotojpa.repositories;

import com.ironhack.labjavaintrotojpa.enums.CustomerStatus;
import com.ironhack.labjavaintrotojpa.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
        customerRepository.deleteAll();
        Customer customer1 = new Customer("Augustine Riviera", CustomerStatus.GOLD, 115235);
        Customer customer2 = new Customer("Alaina Sepulvida", CustomerStatus.NONE, 6008);
        Customer customer3 = new Customer("Tom Jones", CustomerStatus.GOLD, 205767);
        Customer customer4 = new Customer("Sam Rio", CustomerStatus.NONE, 2653);
        Customer customer5 = new Customer("Jessica James", CustomerStatus.SILVER, 127656);
        Customer customer6 = new Customer("Ana Janco", CustomerStatus.SILVER, 136773);
        Customer customer7 = new Customer("Jennifer Cortez", CustomerStatus.GOLD, 300582);
        Customer customer8 = new Customer("Christian Janco", CustomerStatus.SILVER, 14642);
        customerRepository.saveAll(List.of(customer1, customer2, customer3, customer4, customer5, customer6, customer7, customer8));
    }

    @Test
    void findByName() {
        List<Customer> customers = customerRepository.findCustomerByCustomerName("Jessica");
        assertEquals(1, customers.size());
        assertEquals("Jessica James", customers.get(0).getCustomerName());
    }

    @Test
    void findByStatus() {
        List<Customer> customers = customerRepository.findCustomerByCustomerStatus(CustomerStatus.GOLD);
        assertEquals(3, customers.size());
        assertEquals("Augustine Riviera", customers.get(0).getCustomerName());
        assertEquals("Jennifer Cortez", customers.get(1).getCustomerName());
    }
}