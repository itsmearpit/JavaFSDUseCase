/**
 * 
 */
package com.example.MovieService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

import com.example.MovieService.Model.Movie;
import com.example.MovieService.Service.MovieService;

/**
 * @author Lenovo
 *
 */
@RestController
@RequestMapping("/movie")
public class MovieController {

	
	@Autowired
	MovieService service;
	
	@Value("${server.port}")
	public String port;
	
	@GetMapping("/port")
	public String getPort() {
		return "Application is running on port: "+port;
	}

	@GetMapping("/all")
	public ResponseEntity<List<Movie>> displayAll()
	{
		return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Movie> getMovieById(@PathVariable("id") Long movieId)
	{   
		return new ResponseEntity<>(service.getMovie(movieId), HttpStatus.CREATED);
	}

	@PostMapping("/save")
	public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie)
	{
		return new ResponseEntity<>(service.save(movie), HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Movie> updateMovie(@PathVariable("id") Long movieId,@RequestBody Movie movie)
	{
		return new ResponseEntity<>(service.update(movieId,movie), HttpStatus.OK);
	}
		
		
		//DELETE-DELETE
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteMOvie(@PathVariable("id") Long movieId)
	{
		return new ResponseEntity<>(service.deleteById(movieId), HttpStatus.OK);
	}
	
	@GetMapping("/search/{keyword}")
	public ResponseEntity<List<Movie>> searchMovie(@PathVariable("keyword") String keyword){
		return new ResponseEntity<>(service.searchMovie(keyword), HttpStatus.OK);
	}
		
}
