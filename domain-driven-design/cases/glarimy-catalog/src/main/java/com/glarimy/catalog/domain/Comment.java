package com.glarimy.catalog.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Comment {
	@Id
	@GeneratedValue
	private int id;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	private String description;
	private int rating;
	@ManyToOne
	private Product product;
	private Customer cid;
	private Order oid;
}
