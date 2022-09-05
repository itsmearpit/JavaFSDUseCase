/**
 * 
 */
package com.example.CustomerService.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Lenovo
 *
 */
@Entity
@Table(name = "Customer")
public class Customer {

	/*customer_id, customer_name, contact_no, contact_address, date_of_registration, age*/
	
	 	@Id
	    private long customer_id;

	    @Column(name = "customer_name")
	    private String customer_name;

	    @Column(name = "contact_no")
	    private String contact_no;

	    @Column(name = "contact_address")
	    private String contact_address;
	
	    @Column(name = "date_of_registration")
	    private String date_of_registration;
		
	    @Column(name = "age")
	    private int age;
	    
	    @Column(name = "username")
	    private String username;

	    @Column(name = "password")
	    private String password;
	
	    @Column(name = "role")
	    private String role;
		
	    @Column(name = "enabled")
	    private int enabled;
	    
		public Customer()
	    {
	    }

		public long getCustomer_id() {
			return customer_id;
		}

		public void setCustomer_id(long customer_id) {
			this.customer_id = customer_id;
		}



		public String getCustomer_name() {
			return customer_name;
		}



		public void setCustomer_name(String customer_name) {
			this.customer_name = customer_name;
		}



		public String getContact_no() {
			return contact_no;
		}



		public void setContact_no(String contact_no) {
			this.contact_no = contact_no;
		}



		public String getContact_address() {
			return contact_address;
		}



		public void setContact_address(String contact_address) {
			this.contact_address = contact_address;
		}



		public String getDate_of_registration() {
			return date_of_registration;
		}



		public void setDate_of_registration(String date_of_registration) {
			this.date_of_registration = date_of_registration;
		}



		public int getAge() {
			return age;
		}



		public void setAge(int age) {
			this.age = age;
		}
	
	    public String getUsername() {
			return username;
		}



		public void setUsername(String username) {
			this.username = username;
		}



		public String getPassword() {
			return password;
		}



		public void setPassword(String password) {
			this.password = password;
		}



		public String getRole() {
			return role;
		}



		public void setRole(String role) {
			this.role = role;
		}



		public int getEnabled() {
			return enabled;
		}



		public void setEnabled(int enabled) {
			this.enabled = enabled;
		}

		public Customer(long customer_id, String customer_name, String contact_no, String contact_address,
				String date_of_registration, int age, String username, String password, String role, int enabled) {
			super();
			this.customer_id = customer_id;
			this.customer_name = customer_name;
			this.contact_no = contact_no;
			this.contact_address = contact_address;
			this.date_of_registration = date_of_registration;
			this.age = age;
			this.username = username;
			this.password = password;
			this.role = role;
			this.enabled = enabled;
		}
	
	

}
