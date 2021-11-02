package io.vishal.movieinfoservice.models;

public class Movie {

	private String Id;
	private String name;
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Movie(String id, String name) {
		super();
		Id = id;
		this.name = name;
	}
	
	
	
}
