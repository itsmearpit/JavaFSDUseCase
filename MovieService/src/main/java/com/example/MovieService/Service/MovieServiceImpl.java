package com.example.MovieService.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MovieService.Model.Movie;
import com.example.MovieService.Repository.MovieRepository;

/**
 * @author Lenovo
 *
 */
@Service
public class MovieServiceImpl implements MovieService{

	@Autowired
	private MovieRepository movieRepo;
	
	@Override
	public List<Movie> getAll() {
		// TODO Auto-generated method stub
		return movieRepo.findAll();
	}
	
	@Override
	public Movie getMovie(long movieId) {
		// TODO Auto-generated method stub
		return movieRepo.findById(movieId).get();
	}

	@Override
	public Movie save(Movie movie) {
		// TODO Auto-generated method stub
		return movieRepo.save(movie);
	}

	@Override
	public Movie update(long movieId,Movie movie) {
		// TODO Auto-generated method stub
		Movie movieToUpdate = movieRepo.findById(movieId).get();
		if(movie.getMovie_name() != null)
		{
			movieToUpdate.setMovie_name(movie.getMovie_name());
		}
		if(movie.getLanguage() != null)
		{
			movieToUpdate.setLanguage(movie.getLanguage());
		}
		if(movie.getRental_cost() != 0)
		{
			movieToUpdate.setRental_cost(movie.getRental_cost());
		}
		return movieRepo.save(movieToUpdate);
	}

	@Override
	public String deleteById(long movieId) {
		// TODO Auto-generated method stub
		this.movieRepo.deleteById(movieId);
		return "Movie deleted...";
	}

	@Override
	public List<Movie> searchMovie(String keyword) {
		// TODO Auto-generated method stub
		return movieRepo.searchMovie(keyword);
	}

}
