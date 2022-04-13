package com.vti;

import com.vti.entity.Article;
import com.vti.repository.ArticleRepository;

public class App {

	public static void main(String[] args) {
		ArticleRepository repository = new ArticleRepository();

		Article article = new Article();
		article.setTitle("Java 3 Exam");
		article.setType("Java");
		repository.createArticle(article);
	}

}

