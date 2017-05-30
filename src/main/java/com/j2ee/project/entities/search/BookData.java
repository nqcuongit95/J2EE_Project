package com.j2ee.project.entities.search;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

public class BookData {

	@JsonView(Views.Show.class)
	String title;
	@JsonView(Views.Show.class)
	String ISBN;
	@JsonView(Views.Show.class)
	String description;
	@JsonView(Views.Show.class)
	List<String> authors;
	@JsonView(Views.Show.class)
	List<String> categories;
	@JsonView(Views.Show.class)
	Timestamp datePublished;
	@JsonView(Views.Show.class)
	String publisher;
	@JsonView(Views.Show.class)
	String imageUrl;
	@JsonView(Views.Show.class)
	int id;
	@JsonView(Views.Show.class)
	BigDecimal rentPrice;
	
	public BigDecimal getRentPrice() {
		return rentPrice;
	}
	public void setRentPrice(BigDecimal rentPrice) {
		this.rentPrice = rentPrice;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<String> getAuthors() {
		return authors;
	}
	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}
	public List<String> getCategories() {
		return categories;
	}
	public void setCategories(List<String> categories) {
		this.categories = categories;
	}
	public Timestamp getDatePublished() {
		return datePublished;
	}
	public void setDatePublished(Timestamp datePublished) {
		this.datePublished = datePublished;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
		
}
