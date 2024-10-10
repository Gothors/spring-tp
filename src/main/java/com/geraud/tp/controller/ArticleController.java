package com.geraud.tp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.geraud.tp.model.Article;
import com.geraud.tp.service.ArticleService;

import java.util.List;
import java.util.Optional;

@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/articles")
    public Iterable<Article> getArticles() {
        return articleService.getArticles();
    }

    @PostMapping("/article")
    public Article createArticle(@RequestBody Article article) {
        return articleService.saveArticle(article);
    }

    @GetMapping("/article/{id}")
    public Article getArticle(@PathVariable("id") final Long id) {
        Optional<Article> article = articleService.getArticle(id);
        return article.orElse(null);
    }

    @PutMapping("/article/{id}")
    public Article updateArticle(@PathVariable("id") final Long id, @RequestBody Article article) {
        Optional<Article> existingArticle = articleService.getArticle(id);
        if (existingArticle.isPresent()) {
            Article currentArticle = existingArticle.get();
            currentArticle.setTitle(article.getTitle());
            currentArticle.setContent(article.getContent());
            return articleService.saveArticle(currentArticle);
        } else {
            return null;
        }
    }

    @DeleteMapping("/article/{id}")
    public void deleteArticle(@PathVariable("id") final Long id) {
        articleService.deleteArticle(id);
    }
    
    /**
    * Read - Get all Articles by User
    * @param id The id of the User
    * @return An list of Articles object by user
    */
//    @GetMapping("/articles/{id}")
//    public List<Article> getArticlesByUser(@PathVariable final Long id) {
//    return articleService.getArticlesByUser(id);
//    }

}
