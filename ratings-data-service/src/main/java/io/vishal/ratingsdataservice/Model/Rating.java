package io.vishal.ratingsdataservice.Model;

public class Rating {

	private String id;
	private int rating;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public Rating(String id, int rating) {
		super();
		this.id = id;
		this.rating = rating;
	}
	
	
}
