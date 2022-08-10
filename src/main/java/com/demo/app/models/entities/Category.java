package com.demo.app.models.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "category")
public class Category implements Serializable {
	@Id
	@Column(name = "category_id")
	private long id;

	@Column(name = "category_name")
	private String name;

	public Category(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Category(String name) {
		super();
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + "]";
	}
}
