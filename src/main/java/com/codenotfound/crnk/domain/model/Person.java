package com.codenotfound.crnk.domain.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiRelation;
import io.crnk.core.resource.annotations.JsonApiResource;

@Entity
@JsonApiResource(type = "people")
public class Person {
	private static final long serialVersionUID = 1L;
	@Id
  @JsonApiId
  private Long id;

  private String name;

  @JsonApiRelation(opposite = "author")
  @OneToMany
  private List<ArticleEntity> articles = new ArrayList<>();

  public Person() {
    super();
  }

  public Person(Long id, String name, List<ArticleEntity> articles) {
	super();
	this.id = id;
	this.name = name;
	this.articles = articles;
}




public Long getId() {
	return id;
}




public String getName() {
	return name;
}




public List<ArticleEntity> getArticles() {
	return articles;
}




public void setId(Long id) {
	this.id = id;
}




public void setName(String name) {
	this.name = name;
}




public void setArticles(List<ArticleEntity> articles) {
	this.articles = articles;
}




@Override
  public String toString() {
    return "person[id=" + id + ", name=" + name + "]";
  }
}