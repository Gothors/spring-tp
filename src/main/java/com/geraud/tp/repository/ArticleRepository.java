package com.geraud.tp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import com.geraud.tp.model.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    // Tu peux ajouter des méthodes de requête personnalisées ici si nécessaire
	@EntityGraph(attributePaths = {"user"})
	List<Article> findByUserId(Long userId);
}