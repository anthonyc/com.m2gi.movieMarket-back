package com.m2gi.movieMarket.domain.entity.movie;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;
import java.util.Collection;

import javax.persistence.*;

import com.m2gi.movieMarket.domain.entity.cart.*;
import com.m2gi.movieMarket.domain.entity.order.*;

@Entity
@Table(name = "movie")
public class Movie implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="movie_id")
	private int id;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	@JoinTable(
		name = "movie_category",
		joinColumns = { @JoinColumn(name = "movie_id") },
		inverseJoinColumns = { @JoinColumn(name = "category_id") }
	)
	private Set<Category> categories;

	@OneToMany(mappedBy = "movie")
	private Collection<CartDetail> cartDetailCollection;

	@OneToMany(mappedBy = "movie")
	private Collection<OrderDetail> orderDetailCollection;
	
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

	@Column(name = "releaseYear", columnDefinition = "DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
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

	public int getReleaseYear() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(this.releaseYear);

		return calendar.get(Calendar.YEAR);
	}
	
	public Movie setReleaseYear(int year) throws InvalidParameterException {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");

		try {
			this.releaseYear = format.parse(String.valueOf(year) + "-01-01 00:00:00");
		} catch (ParseException e) {
			throw new InvalidParameterException("The expected paramter is a integer year");
		}

		return this;
	}
}
