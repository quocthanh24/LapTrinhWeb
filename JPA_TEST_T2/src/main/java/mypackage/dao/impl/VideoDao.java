package mypackage.dao.impl;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import mypackage.config.JPAConfig;
import mypackage.dao.IVideoDao;
import mypackage.entity.Category;
import mypackage.entity.Video;

public class VideoDao implements IVideoDao{
	
	
	@Override
	public void insert(Video video) {
		EntityManager enma = JPAConfig.getEntityManager();
		 EntityTransaction trans = enma.getTransaction();
		
		 try {
			 
			 trans.begin();
			//gọi phương thức để thực hiện CRUD
			 enma.persist(video);
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
	public void update(Video video) {
		EntityManager enma = JPAConfig.getEntityManager();
		 EntityTransaction trans = enma.getTransaction();
		
		 try {
			 
			 trans.begin();
			//gọi phương thức để thực hiện CRUD
			 enma.merge(video);
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
	public void delete(int videoid)throws Exception{
		EntityManager enma = JPAConfig.getEntityManager();
		 EntityTransaction trans = enma.getTransaction();
		
		 try {
			 
			 trans.begin();
			//gọi phương thức để thực hiện CRUD
			 Category category = enma.find(Category.class, videoid);
			 
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
	public Video findById(int videoid) {
		EntityManager enma = JPAConfig.getEntityManager();
		Video video = enma.find(Video.class, videoid);
		return video;
	}
	
	
	
	@Override
	public List<Video> findAll() {
		EntityManager enma = JPAConfig.getEntityManager();
		TypedQuery<Video> query = enma.createQuery("Video.findAll", Video.class);
		
		
		return query.getResultList();
	}


	
	
	@Override
	public List<Video> findByCategoryId(String categoryid){
		
		EntityManager enma = JPAConfig.getEntityManager();
		String sql = "Select v from Video v "
				+	 "WHERE v.category.categoryid = cateid";
		TypedQuery<Video> query = enma.createQuery(sql, Video.class);
		query.setParameter("cateid", categoryid );
		
		return query.getResultList();
		
		
	}
	
	
	
	
	
	
}
