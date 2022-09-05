/**
 * 
 */
package com.example.MovieService.Service;

import java.util.List;

import com.example.MovieService.Model.Movie;

/**
 * @author Lenovo
 *
 */
public interface MovieService {
		
	public List<Movie> getAll();
	public Movie getMovie(long movieId);
	public Movie save(Movie movie);
	public Movie update(long movieId,Movie movie);
	public String deleteById(long movieId);
	public List<Movie> searchMovie(String keyword);

}
