package com.vti;

import java.util.Date;
import java.util.List;

import com.vti.entity.Article;
import com.vti.repository.ArticleRepository;

public class App {

    public static void main( String[] args ) {
        ArticleRepository repo = new ArticleRepository();
        
        List<Article> articles = repo.getAll();
        System.out.println("Size: " + articles.size());
        System.out.println(articles.get(0).getFull());
        
        Article a1 = new Article();
        a1.setTitle("Bai viet 1");
        a1.setContent("Content 1");
        a1.setCreatedDate(new Date());
        a1.setUpdatedDate(new Date());
        a1.setDeletedDate(new Date());
        a1.setRegisteredDate(new Date());

        repo.create(a1);
    }

}
