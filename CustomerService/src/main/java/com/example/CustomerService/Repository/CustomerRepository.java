/**
 * 
 */
package com.example.CustomerService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.CustomerService.Model.Customer;

/**
 * @author Lenovo
 *
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
