package mypackage.dao;

import java.util.List;

import mypackage.entity.Category;

public interface ICategoryDaO {

	int count();

	List<Category> findAll(int page, int pagesize);

	List<Category> findByCategoryName(String catename);

	List<Category> findAll();

	Category findById(int cateid);

	void delete(int cateid) throws Exception;

	void update(Category category);

	void insert(Category category);

	

}
