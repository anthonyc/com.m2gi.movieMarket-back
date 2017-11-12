package com.m2gi.movieMarket.domain.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="movie")
public class Movie implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="img")
	private String img;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	public int getId() {
		return this.id;
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
	
	@Override
	public String toString() {
		return "com.m2gi.movieMarket.domaine.entity.Movie[id=" + id + "]";
	}
}
