package mypackage.service.impl;

import java.util.List;

import mypackage.dao.ICategoryDaO;
import mypackage.dao.impl.CategoryDao;
import mypackage.entity.Category;
import mypackage.service.ICategoryService;

public class CategoryService implements ICategoryService{

	ICategoryDaO cateDao = new CategoryDao();
	
	
	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		
		return cateDao.findAll();
		
		
	}

	@Override
	public Category findById(int cateid) {
		// TODO Auto-generated method stub
		
		return cateDao.findById(cateid);
		
	}



	@Override
	public void update(Category category) {
		// TODO Auto-generated method stub
		cateDao.update(category);
	}

	@Override
	public void insert(Category category) {
		// TODO Auto-generated method stub
		cateDao.insert(category);
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		
		
		
		return cateDao.count();
	}

	@Override
	public List<Category> findAll(int page, int pagesize) {
		// TODO Auto-generated method stub
		return cateDao.findAll();
	}

	@Override
	public List<Category> findByCategoryName(String catename) {
		// TODO Auto-generated method stub
		return cateDao.findByCategoryName(catename);
	}

	@Override
	public void delete(int cateid) throws Exception {
		// TODO Auto-generated method stub
		cateDao.delete(cateid);
	}

	
	
	
}
