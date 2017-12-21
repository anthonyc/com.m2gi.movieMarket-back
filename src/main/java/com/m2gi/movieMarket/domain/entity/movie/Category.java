package com.m2gi.movieMarket.domain.entity.movie;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

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

	private Date created;

	private Date updated;

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

	@PrePersist
	protected void onCreate() {
		created = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		updated = new Date();
	}
}
