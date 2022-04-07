package com.vti.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "article")
public class Article {
	
	@Id
	@GenericGenerator(
		name = "article-sequence-generator",
		strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
		parameters = {
			@Parameter(name="sequence_name", value = "article_sequence"),
			@Parameter(name="initial_value", value = "10"),
			@Parameter(name="increment_size", value = "5")
		}
	)
	@GeneratedValue(generator = "article-sequence-generator")
	private Integer id;

	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
