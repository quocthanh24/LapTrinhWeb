package mypackage.service.impl;

import java.util.List;

import mypackage.dao.IVideoDao;
import mypackage.dao.impl.VideoDao;
import mypackage.entity.Video;
import mypackage.service.IVideoService;

public class VideoService implements IVideoService{

	IVideoDao videodao = new VideoDao();
	
	
	@Override
	public void delete(int videoid) throws Exception {
		// TODO Auto-generated method stub
		videodao.delete(videoid);
	}

	@Override
	public void update(Video video) {
		// TODO Auto-generated method stub
		videodao.update(video);
	}

	@Override
	public void insert(Video video) {
		// TODO Auto-generated method stub
		videodao.insert(video);
	}

	@Override
	public List<Video> findAll() {
		// TODO Auto-generated method stub
		return videodao.findAll();
	}

	@Override
	public List<Video> findByCategoryId(String categoryid) {
		// TODO Auto-generated method stub
		return videodao.findByCategoryId(categoryid);
	}

	@Override
	public Video findById(int videoid) {
		// TODO Auto-generated method stub
		return videodao.findById(videoid);
	}
	
}
