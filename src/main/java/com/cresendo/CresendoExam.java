package com.cresendo;

import java.io.IOException;

import org.apache.http.HttpHeaders;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cresendo.exception.BusinessNotFoundException;
import com.cresendo.model.Business;
import com.cresendo.model.Businesses;
import com.cresendo.model.Reviews;

@SpringBootApplication
@RestController
public class CresendoExam {
	public static final String YELP_API = "https://api.yelp.com/v3/businesses";

	@Autowired
	private ObjectMapperProvider omp;

	public static void main(String[] args) {
		SpringApplication.run(CresendoExam.class, args);
	}

	@GetMapping("/yelp")
	public Businesses getRestaurant(@RequestParam(value = "location") String location,
			@RequestHeader("Authorization") String authHeader) throws IOException {
		HttpGet getYelpBusiness = new HttpGet(YELP_API + "/search?location=" + location);
		getYelpBusiness.addHeader(HttpHeaders.AUTHORIZATION, authHeader);
		getYelpBusiness.addHeader(HttpHeaders.CONTENT_TYPE, "application/json");

		CloseableHttpResponse response = null;
		try {
			CloseableHttpClient client = HttpClientBuilder.create().build();
			response = client.execute(getYelpBusiness);
			return omp.convertJsonToObject(response.getEntity(), Businesses.class);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} finally {
			response.close();
		}
		return null;
	}

	@GetMapping("/yelp/{id}")
	public Business getBusiness(@PathVariable(value = "id") String id,
			@RequestHeader("Authorization") String authHeader)
			throws IOException {
		HttpGet getYelpBusiness = new HttpGet(YELP_API + "/" + id);
		getYelpBusiness.addHeader(HttpHeaders.AUTHORIZATION, authHeader);
		getYelpBusiness.addHeader(HttpHeaders.CONTENT_TYPE, "application/json");

		CloseableHttpResponse response = null;
		try {
			CloseableHttpClient client = HttpClientBuilder.create().build();
			response = client.execute(getYelpBusiness);
			Business business = omp.convertJsonToObject(response.getEntity(), Business.class);
			if (HttpStatus.NOT_FOUND.value() == response.getStatusLine().getStatusCode()) {
				throw new BusinessNotFoundException();
			}
			return business;
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} finally {
			response.close();
		}
		return null;
	}

	@GetMapping("/yelp/{id}/reviews")
	public Reviews getBusinessReviews(@PathVariable(value = "id") String id,
			@RequestHeader("Authorization") String authHeader) throws IOException {
		HttpGet getReviews = new HttpGet(YELP_API + "/" + id + "/reviews");
		getReviews.addHeader(HttpHeaders.AUTHORIZATION, authHeader);
		getReviews.addHeader(HttpHeaders.CONTENT_TYPE, "application/json");

		CloseableHttpResponse response = null;
		try {
			CloseableHttpClient client = HttpClientBuilder.create().build();
			response = client.execute(getReviews);
			if (HttpStatus.NOT_FOUND.value() == response.getStatusLine().getStatusCode()) {
				throw new BusinessNotFoundException();
			}
			return omp.convertJsonToObject(response.getEntity(), Reviews.class);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} finally {
			response.close();
		}
		return null;
	}
}
