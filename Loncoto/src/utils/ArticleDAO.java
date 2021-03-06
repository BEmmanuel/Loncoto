package utils;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import beans.Article;

public class ArticleDAO implements IArticleDAO {

	@PersistenceContext
	private EntityManager em;
	public EntityManager getEm() {
		return em;
	}
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	@Override
	@Transactional
	public List<Article> findAll() {
		return em.createQuery("from Article", Article.class).getResultList();
	}
	
	@Override
	@Transactional
	public Article findByID(int id) {
		return em.find(Article.class, id);
	}
	
	@Override
	@Transactional
	public Article save(Article article) {
		if (article == null)
			return article;
		if(article.getId()>0)
			em.merge(article);
		else
			em.persist(article);
		return article;
	}

	

}
