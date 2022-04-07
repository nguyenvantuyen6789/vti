package com.vti;

import java.util.List;

import com.vti.entity.Article;
import com.vti.enums.ArticleStatus;
import com.vti.repository.ArticleRepository;

public class App 
{
    public static void main( String[] args ) {
    	
        ArticleRepository repo = new ArticleRepository();
        List<Article> articles = repo.getAllArticles();
        for (int i = 0; i < articles.size(); i++) {
			System.out.println(articles.get(i).getTitle());
		}
        
        Article article1 = new Article();
        article1.setTitle("Article 89");
        article1.setArticleStatus(ArticleStatus.OPEN);
        repo.createArticle(article1);
        
    }
}
