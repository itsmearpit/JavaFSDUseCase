package com.example.CustomerService.Service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.CustomerService.Model.MovieDto;

@FeignClient("movieservice")
public interface FeignProxy {
	
	@GetMapping("/movie/search/{keyword}")
	public List<MovieDto> searchMovie(@PathVariable("keyword") String keyword);
	
	@GetMapping("/movie/port")
	public String getPort();
	
}
