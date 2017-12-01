package com.m2gi.movieMarket.domain.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="movie")
public class Movie implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	@JoinTable(
		name = "movie_category",
		joinColumns = { @JoinColumn(name = "movie_id") },
		inverseJoinColumns = { @JoinColumn(name = "category_id") }
	)
	private Set<Category> categories;
	
	@Column(name = "img")
	private String img;
	
	@Column(name = "name")
	private String name;
	
	@Lob
	@Column(name = "description")
	private String description;

	@Column(name = "price")
	private float price;

	@Column(name = "quantity")
	private int quantity;

	@Column(name = "releaseYear")
	private Date releaseYear;
	
	public int getId() {
		return this.id;
	}
	
	public Set<Category> getCategories() {
		return this.categories;
	}

	public Movie setCategories(Set<Category> categories) {
		this.categories = categories;
		
		return this;
	}
	
	public String getImg() {
		return img;
	}

	public Movie setImg(String img) {
		this.img = img;
		
		return this;
	}

	public String getName() {
		return this.name;
	}
	
	public Movie setName(String name) {
		this.name = name;
		
		return this;
	}

	public String getDescription() {
		return this.description;
	}

	public Movie setDescription(String description) {
		this.description = description;

		return this;
	}

	public float getPrice() {
		return this.price;
	}
	
	public Movie setPrice(float price) {
		this.price = price;
		
		return this;
	}

	public int getQuantity() {
		return this.quantity;
	}
	
	public Movie setQuantity(int quantity) {
		this.quantity = quantity;
		
		return this;
	}

	public Date getReleaseYear() {
		return this.releaseYear;
	}
	
	public Movie setReleaseYear(Date releaseYear) {
		this.releaseYear = releaseYear;
		
		return this;
	}
}
