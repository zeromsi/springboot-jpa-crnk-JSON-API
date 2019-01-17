package com.codenotfound.crnk;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.codenotfound.crnk.domain.model.ArticleEntity;
import com.codenotfound.crnk.domain.model.Person;
import com.mysql.fabric.xmlrpc.base.Array;

import io.crnk.core.engine.transaction.TransactionRunner;

@Configuration
public class SpringCrnkApplicationConfig {

  @Autowired
  private EntityManager entityManager;

  @Autowired
  private TransactionRunner transactionRunner;

  @PostConstruct
  public void init() {
    transactionRunner.doInTransaction(new Callable<Object>() {
      @Override
      public Object call() throws Exception {
        ArticleEntity article1 = new ArticleEntity(1L, "JSON API paints my bikeshed!");
        ArticleEntity article2 = new ArticleEntity(2L, "Rails is Omakase");

        entityManager.persist(article1);
        entityManager.persist(article2);
        entityManager.flush();
List<ArticleEntity> ArticleEntitys=new ArrayList<>();
ArticleEntitys.add(article1);
ArticleEntitys.add(article2);
        Person peron1=new Person(1L, "JSON API paints my bikeshed!",ArticleEntitys);
        entityManager.persist(peron1);
        entityManager.flush();
        return null;
      }
    });
  }
}