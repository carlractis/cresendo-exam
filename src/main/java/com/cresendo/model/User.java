package com.cresendo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
	@JsonProperty("id")
	private String id;

	@JsonProperty("profile_url")
	private String profile_url;

	@JsonProperty("image_url")
	private String image_url;

	@JsonProperty("name")
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProfile_url() {
		return profile_url;
	}

	public void setProfile_url(String profile_url) {
		this.profile_url = profile_url;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
