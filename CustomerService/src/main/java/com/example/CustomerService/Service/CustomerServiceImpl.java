/**
 * 
 */
package com.example.CustomerService.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CustomerService.Model.Customer;
import com.example.CustomerService.Model.MovieDto;
import com.example.CustomerService.Repository.CustomerRepository;


/**
 * @author Lenovo
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService{

	
	@Autowired
	private CustomerRepository custRepo;
	
	@Autowired
	FeignProxy proxy;

	@Override
	public List<Customer> getAll() {
		// TODO Auto-generated method stub
		return custRepo.findAll();
	}

	@Override
	public Customer getCustomer(long customerId) {
		// TODO Auto-generated method stub
		return custRepo.findById(customerId).get();
	}

	@Override
	public Customer save(Customer customer) {
		// TODO Auto-generated method stub
		customer.setRole("ROLE_USER");
		customer.setEnabled(1);
		return custRepo.save(customer);
	}

	@Override
	public Customer update(long customerId, Customer customer) {
		// TODO Auto-generated method stub
		Customer custToUpdate = custRepo.findById(customerId).get();
		if(customer.getCustomer_name() != null)
		{
			custToUpdate.setCustomer_name(customer.getCustomer_name());
		}
		if(customer.getContact_no() != null)
		{
			custToUpdate.setContact_no(customer.getContact_no());
		}
		if(customer.getContact_address() != null)
		{
			custToUpdate.setContact_address(customer.getContact_address());
		}
		if(customer.getPassword() != null)
		{
			custToUpdate.setPassword(customer.getPassword());
		}
		return custRepo.save(custToUpdate);
	}

	@Override
	public String deleteById(long customerId) {
		// TODO Auto-generated method stub
		custRepo.deleteById(customerId);
		return "Customer deleted...";
	}

	@Override
	public List<MovieDto> searchMovie(String keyword) {
		// TODO Auto-generated method stub
		return proxy.searchMovie(keyword);
	}
	
	@Override
	public String getPort() {
		return proxy.getPort();
	}
	

}
