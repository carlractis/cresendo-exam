package com.cresendo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Review {

	@JsonProperty("id")
	private String id;

	@JsonProperty("rating")
	private Integer rating;

	@JsonProperty("text")
	private String text;

	@JsonProperty("time_created")
	private String time_created;

	@JsonProperty("url")
	private String url;

	@JsonProperty("user")
	private User user;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getTime_created() {
		return time_created;
	}

	public void setTime_created(String time_created) {
		this.time_created = time_created;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
