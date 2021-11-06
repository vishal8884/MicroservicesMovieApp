package io.vishal.ratingsdataservice.Controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.vishal.ratingsdataservice.Model.Rating;
import io.vishal.ratingsdataservice.Model.UserRating;

@RestController
@RequestMapping("ratingsdata")
public class RatingController {

	@RequestMapping("/{movieId}")
	public Rating getRating(@PathVariable("movieId") String movieId)
	{
		return new Rating(movieId, 5);
	}
	
	@RequestMapping("users/{userId}")
	public UserRating getRating2(@PathVariable("userId") String userId)
	{
		List<Rating> ratings = Arrays.asList(
				new Rating("1", 4),
				new Rating("2", 1),
				new Rating("3", 5)
				);
		
		//return ratings;   insted of returning list directly to api...create a seperate object for list and return
		
		UserRating userRating = new UserRating();
		userRating.setUserRating(ratings);
		 
		return userRating;
	}
	
//	@RequestMapping("users/{userId}")
//	public List<Rating> getRating2(@PathVariable("userId") String userId)
//	{
//		List<Rating> ratings = Arrays.asList(
//				new Rating("1", 4),
//				new Rating("2", 1),
//				new Rating("3", 5)
//				);
//		
//		
//		return ratings;
//	}
	

}
