package com.m2gi.movieMarket.domain.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class Category implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@ManyToMany(mappedBy = "categories")
	private Set<Movie> movies;
	
	@Column(name = "name")
	private String name;

	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	public Category setName(String name) {
		this.name = name;
		
		return this;
	}
}
