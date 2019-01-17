package com.codenotfound.crnk.domain.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiRelation;
import io.crnk.core.resource.annotations.JsonApiResource;

@Entity
@JsonApiResource(type = "article")
public class ArticleEntity {
	private static final long serialVersionUID = 1L;
	@Id
	@JsonApiId
	private Long id;

	private String title;

	@JsonApiRelation(opposite = "articles")
	@ManyToOne
	@JoinColumn(name = "articles")
	private Person author;

	public ArticleEntity() {
		super();
	}

	public ArticleEntity(Long id, String title) {
		super();
		this.id = id;
		this.title = title;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "article[id=" + id + ", title=" + title + "]";
	}
}