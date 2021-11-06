package io.vishal.moviecatalogService.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import io.vishal.moviecatalogService.models.CatalogItem;
import io.vishal.moviecatalogService.models.Movie;
import io.vishal.moviecatalogService.models.Rating;
import io.vishal.moviecatalogService.models.UserRating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {
	
	@Autowired
	@Qualifier("restT")
	private RestTemplate restTemplate;
	
	@Autowired
	@Qualifier("WebClinett")
	private WebClient.Builder webClient;
	
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalogByUserId(@PathVariable("userId") String userId)
	{
		
		
//		List<Rating> ratings = Arrays.asList(
//				new Rating("1", 4),
//				new Rating("2", 1),
//				new Rating("3", 5)
//				);
		
		//if you return list this complications will be there in api where you need to define class 
		//List<Rating> ratings = restTemplate.getForObject("http://localhost:8083/ratingsdata/users/"+userId,listClasscustom);
		
		UserRating userRating = restTemplate.getForObject("http://localhost:8083/ratingsdata/users/"+userId, UserRating.class);
		
		
		List<CatalogItem> catalog = userRating.getUserRating().stream().map(rating ->
		{
			Movie movie=restTemplate.getForObject("http://localhost:8082/movies/"+rating.getId(), Movie.class);
			
//			Movie movie=webClient.build()
//			.get()
//			.uri("http://localhost:8082/movies/"+rating.getId())
//			.retrieve()
//			.bodyToMono(Movie.class)
//			.block();
			
			return new CatalogItem(movie.getName(), "desc", rating.getRating());
		})
	    .collect(Collectors.toList());		
		
		
	//	
//		List<CatalogItem> catalogs2  = new ArrayList<>();
//		for(Rating rating : ratings)
//		{
//			Movie movie=restTemplate.getForObject("http://localhost:8082/movies/"+rating.getId(), Movie.class);
//			catalogs2.add(new CatalogItem(movie.getName(),"desc", rating.getRating()));
//		}

				
		return catalog;

	}
}

/*
@RequestMapping("/{userId}")
public List<CatalogItem> getCatalogByUserId(@PathVariable("userId") String userId)
{
	
	
//	List<Rating> ratings = Arrays.asList(
//			new Rating("1", 4),
//			new Rating("2", 1),
//			new Rating("3", 5)
//			);
	
	//if you return list this complications will be there in api where you need to define class 
	//List<Rating> ratings = restTemplate.getForObject("http://localhost:8083/ratingsdata/users/"+userId,listClasscustom);
	
	UserRating userRating = restTemplate.getForObject("http://localhost:8083/ratingsdata/users/"+userId, UserRating.class);
	
	
	List<CatalogItem> catalog = userRating.getUserRating().stream().map(rating ->
	{
		Movie movie=restTemplate.getForObject("http://localhost:8082/movies/"+rating.getId(), Movie.class);
		
//		Movie movie=webClient.build()
//		.get()
//		.uri("http://localhost:8082/movies/"+rating.getId())
//		.retrieve()
//		.bodyToMono(Movie.class)
//		.block();
		
		return new CatalogItem(movie.getName(), "desc", rating.getRating());
	})
    .collect(Collectors.toList());		
	
	
//	
//	List<CatalogItem> catalogs2  = new ArrayList<>();
//	for(Rating rating : ratings)
//	{
//		Movie movie=restTemplate.getForObject("http://localhost:8082/movies/"+rating.getId(), Movie.class);
//		catalogs2.add(new CatalogItem(movie.getName(),"desc", rating.getRating()));
//	}

			
	return catalog;

}
*/