package mypackage.dao;

import java.util.List;

import mypackage.entity.Category;
import mypackage.entity.Video;

public interface IVideoDao {
	
	
	void delete(int videoid) throws Exception;

	void update(Video video);

	void insert(Video video);

	List<Video> findAll();

	List<Video> findByCategoryId(String categoryid);

	Video findById(int videoid);

}
