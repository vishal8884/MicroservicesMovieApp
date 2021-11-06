package io.vishal.moviecatalogService.models;

import java.util.List;

public class UserRating {

	public UserRating()
	{
		
	}
	
	public UserRating(List<Rating> userRating) {
		super();
		this.userRating = userRating;
	}

	public List<Rating> userRating;

	public List<Rating> getUserRating() {
		return userRating;
	}

	public void setUserRating(List<Rating> userRating) {
		this.userRating = userRating;
	}
}
