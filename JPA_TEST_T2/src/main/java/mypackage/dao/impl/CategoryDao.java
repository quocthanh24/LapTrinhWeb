package mypackage.dao.impl;

import java.util.List;



import jakarta.persistence.*;
import mypackage.config.JPAConfig;
import mypackage.dao.ICategoryDaO;
import mypackage.entity.Category;


// Để implement , click phải -> Refactor -> Pull up -> Chọn All -> Chọn finish
public class CategoryDao implements ICategoryDaO{
	@Override
	// INSERT = PERSIST
	public void insert(Category category) {
		EntityManager enma = JPAConfig.getEntityManager();
		 EntityTransaction trans = enma.getTransaction();
		
		 try {
			 
			 trans.begin();
			//gọi phương thức để thực hiện CRUD
			 enma.persist(category);
			 trans.commit();
		 
		 }
		 catch (Exception e) {

			 e.printStackTrace();
			 trans.rollback();
		 throw e;
		 
		 }
		 finally {
			 
		 enma.close();

		 }
	}
	
	
	@Override
	// UPDATE = MERGE
	public void update(Category category) {
		EntityManager enma = JPAConfig.getEntityManager();
		 EntityTransaction trans = enma.getTransaction();
		
		 try {
			 
			 trans.begin();
			//gọi phương thức để thực hiện CRUD
			 enma.merge(category);
			 trans.commit();
		 
		 }
		 catch (Exception e) {

			 e.printStackTrace();
			 trans.rollback();
		 throw e;
		 
		 }
		 finally {
			 
		 enma.close();

		 }
	}
	
	@Override
	//DELETE = REMOVE
	public void delete(int cateid)throws Exception{
		EntityManager enma = JPAConfig.getEntityManager();
		 EntityTransaction trans = enma.getTransaction();
		
		 try {
			 
			 trans.begin();
			//gọi phương thức để thực hiện CRUD
			 Category category = enma.find(Category.class, cateid);
			 
			 if (category != null) {
				 enma.remove(category);
			 }
			 else {
				 throw new Exception("Không tìm thấy");
			 }
			 
			 trans.commit();
		 
		 }
		 catch (Exception e) {

			 e.printStackTrace();
			 trans.rollback();
		 throw e;
		 
		 }
		 finally {
			 
		 enma.close();

		 }
	}
	
	
	@Override
	public Category findById(int cateid) {
		EntityManager enma = JPAConfig.getEntityManager();
		Category category = enma.find(Category.class, cateid);
		return category;
	}
	
	
	
	@Override
	public List<Category> findAll() {
		EntityManager enma = JPAConfig.getEntityManager();
		TypedQuery<Category> query = enma.createQuery("Category.findAll", Category.class);
		
		
		return query.getResultList();
	}


	
	
	@Override
	public List<Category> findByCategoryName(String catename){
		
		EntityManager enma = JPAConfig.getEntityManager();
		String sql = "Select c from Category c "
				+	 "WHERE c.catename like :catename";
		TypedQuery<Category> query = enma.createQuery(sql, Category.class);
		query.setParameter("catename", "%" + catename + "%");
		
		return query.getResultList();
		
		
	}
	
	
	@Override
	public List<Category> findAll(int page, int pagesize){
		
		EntityManager enma = JPAConfig.getEntityManager();
		TypedQuery<Category> query = enma.createNamedQuery("Category.findAll", Category.class);
		
		
		query.setFirstResult(page*pagesize);
		query.setMaxResults(pagesize);
		
		return query.getResultList();
	}
	@Override
	public int count() {
		// TODO Auto-generated method stub
		EntityManager enma = JPAConfig.getEntityManager();
		
		String sql = "Select count(c) From Category c";
		
		Query query = enma.createQuery(sql);
		return ((Long)query.getSingleResult()).intValue();
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
