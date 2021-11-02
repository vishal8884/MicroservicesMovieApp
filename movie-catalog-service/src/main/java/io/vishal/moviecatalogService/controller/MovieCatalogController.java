package io.vishal.moviecatalogService.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.vishal.moviecatalogService.models.CatalogItem;
import io.vishal.moviecatalogService.models.Movie;
import io.vishal.moviecatalogService.models.Rating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {
	
	
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalogByUserId(@PathVariable("userId") String userId)
	{
		
		RestTemplate restTemplate = new RestTemplate();
		
		
		List<Rating> ratings = Arrays.asList(
				new Rating("1", 4),
				new Rating("2", 1),
				new Rating("3", 5)
				);
		
		List<CatalogItem> catalog = ratings.stream().map(rating ->
		{
			Movie movie=restTemplate.getForObject("http://localhost:8082/movies/"+rating.getId(), Movie.class);
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
