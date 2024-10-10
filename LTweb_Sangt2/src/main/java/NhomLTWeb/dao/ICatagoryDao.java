package NhomLTWeb.dao;

import java.util.List;

import NhomLTWeb.model.CatagoryModel;

public interface ICatagoryDao {
	
	List<CatagoryModel> findAll();
	CatagoryModel findByID(int id);
	CatagoryModel findByName(String name);
	List<CatagoryModel> searchByName(String keyword);
	void insert(CatagoryModel catagory);
	void update(CatagoryModel catagory);
	void delete(int id);
	void updateStatus(int id,int status);
}
