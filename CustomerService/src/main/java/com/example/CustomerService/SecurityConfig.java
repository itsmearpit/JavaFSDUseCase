package com.example.CustomerService;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
	@Autowired
	DataSource dataSource;
	
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception{
		auth.jdbcAuthentication()
		.dataSource(dataSource)
		.passwordEncoder(NoOpPasswordEncoder.getInstance())
		.usersByUsernameQuery("select username, password, enabled from customer where username=?")
		.authoritiesByUsernameQuery("select username, role from customer where username=?");
				
	}
	
	@Override
	protected void configure(HttpSecurity http)throws Exception{
		
		http
		.httpBasic()
		.and()
		.authorizeRequests()
		.antMatchers("/customer/all").hasRole("ADMIN")
		.antMatchers("/customer/get/{id}").hasAnyRole("ADMIN","USER")
		.antMatchers("/customer/save").permitAll()
		.antMatchers("/customer/update/{id}").hasRole("USER")
		.antMatchers("/customer/delete/{id}").hasRole("ADMIN")
		.antMatchers("/customer/search/movie/{keyword}").hasAnyRole("ADMIN","USER")
		.antMatchers("/customer/getPort").hasRole("ADMIN")
		.and().csrf().disable().formLogin();
	}
	
	/*@Bean
    @Override
    public UserDetailsService userDetailsService() {
 
		*
        //User Role
        UserDetails theUser = User.withUsername("sergey")
                        .passwordEncoder(PasswordEncoderFactories.createDelegatingPasswordEncoder()::encode)
                        .password("12345678").roles("USER").build();
        
        //Manager Role 
        UserDetails theManager = User.withUsername("john")
                .passwordEncoder(PasswordEncoderFactories.createDelegatingPasswordEncoder()::encode)
                .password("87654321").roles("USER").build();
        
  
        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
              
        userDetailsManager.createUser(theUser);
        userDetailsManager.createUser(theManager); *
        
        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
        
        List<Customer> cust = custService.getAllCustomers();
        
        for(Customer c:cust)
        {
        	UserDetails theUser = User.withUsername(c.getCustomer_name())
                    .passwordEncoder(PasswordEncoderFactories.createDelegatingPasswordEncoder()::encode)
                    .password(c.getCustomer_name()).roles("USER").build();
        	
        	userDetailsManager.createUser(theUser);
        }
        
        
        return userDetailsManager;
    }*/
}
