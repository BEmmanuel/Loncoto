package utils;

import java.util.List;

import beans.Site;

public interface ISiteDAO {

	public List<Site> findAll();
	public List<Site> findByID(int id);
	public Site save(Site site);
}
