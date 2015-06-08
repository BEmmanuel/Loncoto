package utils;

import java.util.*;
import beans.Article;
	
public interface IArticleDAO {

	public List<Article> findAll();
	public Article findByID(int id);
	public Article save(Article article);
}