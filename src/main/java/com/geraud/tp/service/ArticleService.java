package com.geraud.tp.service;

import java.util.Optional;

import
org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geraud.tp.model.Article;
import com.geraud.tp.repository.ArticleRepository;

@Service
public class ArticleService {
	@Autowired
	private ArticleRepository articleRepository;
	
	public Optional<Article> getArticle(final Long id) {
		return articleRepository.findById(id);
	}
	
		public Iterable<Article> getArticles() {
		return articleRepository.findAll();
	}
		
		public void deleteArticle(final Long id) {
		articleRepository.deleteById(id);
	}
		
	public Article saveArticle(Article article) {
		Article savedArticle = articleRepository.save(article);
		return savedArticle;
	}
	
	
	
}