package com.glarimy.catalog.domain;

import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Product {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	@Embedded
	private Price price;
	@OneToMany()
	private List<Comment> comments;
}