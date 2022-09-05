/**
 * 
 */
package com.example.CustomerService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CustomerService.Model.Customer;
import com.example.CustomerService.Model.MovieDto;
import com.example.CustomerService.Service.CustomerService;


/**
 * @author Lenovo
 *
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService service;
	
	@GetMapping("/all")
	public ResponseEntity<List<Customer>> getAllCustomers()
	{
		return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Customer> getcustbyId(@PathVariable("id") Long customerId)
	{   
		return new ResponseEntity<>(service.getCustomer(customerId), HttpStatus.OK);
	}
	
	//CREATE-POST
	@PostMapping("/save")
	public ResponseEntity<Customer> save(@RequestBody Customer customer)
	{
		return new ResponseEntity<>(service.save(customer), HttpStatus.CREATED);
	}
	
	
	//UPDATE-PUT
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable("id") Long customerId,@RequestBody Customer customer)
	{
		return new ResponseEntity<>(service.update(customerId,customer), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") Long customerId)
	{
		return new ResponseEntity<>(service.deleteById(customerId), HttpStatus.OK);
	}
	
	@GetMapping("/search/movie/{keyword}")
	public ResponseEntity<List<MovieDto>> searchMovie(@PathVariable("keyword") String keyword){
		return new ResponseEntity<>(service.searchMovie(keyword), HttpStatus.OK);
	}
	
	@GetMapping("/getPort")
	public String getPort() {
		return service.getPort();
	}
	
}
