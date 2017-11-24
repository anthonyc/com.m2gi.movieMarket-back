package com.m2gi.movieMarket.domain.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="movie")
public class Movie implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@OneToOne()
	@JoinColumn(name="category_id")
	private Category category;
	
	@Column(name="img")
	private String img;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	public int getId() {
		return this.id;
	}
	
	public Category getCategory() {
		return category;
	}

	public Movie setCategory(Category category) {
		this.category = category;
		
		return this;
	}
	
	public String getImg() {
		return img;
	}

	public Movie setImg(String img) {
		this.img = img;
		
		return this;
	}

	public String getDescription() {
		return description;
	}

	public Movie setDescription(String description) {
		this.description = description;
		
		return this;
	}

	public String getName() {
		return this.name;
	}
	
	public Movie setName(String name) {
		this.name = name;
		
		return this;
	}
}
