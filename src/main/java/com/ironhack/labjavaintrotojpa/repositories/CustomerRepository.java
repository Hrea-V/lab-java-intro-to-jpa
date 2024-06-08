package com.ironhack.labjavaintrotojpa.repositories;

import com.ironhack.labjavaintrotojpa.enums.CustomerStatus;
import com.ironhack.labjavaintrotojpa.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    //Write tests to verify your ability to create new customers.
    //Write tests to verify your ability to find customers by name.
    //Write tests to verify your ability to find customers by status.

    //Find customers by name
    List<Customer> findCustomerByCustomerName(String name);

    //Find customers by status
    List<Customer> findCustomerByCustomerStatus(CustomerStatus status);


//    //JPQL Query Methods
//    //    Find customers by name
//    @Query("SELECT c FROM Customer c WHERE c.customerName = :name")
//    List<Customer> FindByNameJPQL(String name);
//    //    Find customers by status
//    @Query("SELECT c FROM Customer c WHERE c.customerStatus = :status")
//    List<Customer> FindByStatusJPQL(CustomerStatus status);
}
