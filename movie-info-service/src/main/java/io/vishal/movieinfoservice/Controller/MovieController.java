package io.vishal.movieinfoservice.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.vishal.movieinfoservice.models.Movie;

@RestController
@RequestMapping("movies")
public class MovieController {
	
	@RequestMapping("/{movieId}")
	public Movie getMovie(@PathVariable("movieId") String movieId)
	{
		
		return new Movie(movieId,"transformer");
	}

}
