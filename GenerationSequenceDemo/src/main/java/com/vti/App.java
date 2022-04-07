package com.vti;

import com.vti.entity.Article;
import com.vti.repository.ArticleRepository;

public class App {

    public static void main( String[] args ) {
    	ArticleRepository repo = new ArticleRepository();
    	
    	Article article = new Article();
    	article.setName("Hung");
    	repo.create(article);
    }

}
