package utils;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.test.context.ContextConfiguration;

import beans.Article;

public class ArticleDAO implements IArticleDAO {

	EntityManager em;
	
	
	@Override
	public List<Article> findAll() {
		return em.createQuery("from Article", Article.class).getResultList();
	}

	@Override
	public Article findByID(int id) {
		return em.find(Article.class, id);
	}

	@Override
	public Article save(Article article) {
		if(article.getId()>0)
			em.merge(article);
		else
			em.persist(article);
		return article;
	}

	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

}
