/**
 * 
 */
package com.example.CustomerService.Service;

import java.util.List;

import com.example.CustomerService.Model.Customer;
import com.example.CustomerService.Model.MovieDto;

/**
 * @author Lenovo
 *
 */
public interface CustomerService {
				
		public List<Customer> getAll();
		public Customer getCustomer(long customerId);
		public Customer save(Customer customer);
		public Customer update(long customerId,Customer customer);
		public String deleteById(long customerId);
		public List<MovieDto> searchMovie(String keyword);
		public String getPort();

}
