package NhomLTWeb.services.Implement;

import java.util.List;

import NhomLTWeb.dao.ICatagoryDao;
import NhomLTWeb.dao.Implement.CatagoryDaoImpl;
import NhomLTWeb.model.CatagoryModel;
import NhomLTWeb.services.ICatagoryService;

public class CatagoryService implements ICatagoryService {

	public ICatagoryDao catagoryDao = new CatagoryDaoImpl();

	@Override
	public List<CatagoryModel> findAll() {
		// TODO Auto-generated method stub
		return catagoryDao.findAll();
	}

	@Override
	public CatagoryModel findByID(int id) {
		// TODO Auto-generated method stub
		return catagoryDao.findByID(id);
	}

	@Override
	public CatagoryModel findByName(String name) {
		// TODO Auto-generated method stub
		return catagoryDao.findByName(name);
	}

	@Override
	public List<CatagoryModel> searchByName(String keyword) {
		// TODO Auto-generated method stub

		// Làm thêm phương thức check name có tồn tại hay không
		return catagoryDao.searchByName(keyword);
	}

	@Override
	public void insert(CatagoryModel catagory) {
		// TODO Auto-generated method stub
		CatagoryModel cate = this.findByName(catagory.getCatagoryname());

		if (cate == null) {
			catagoryDao.insert(catagory);
		}
	}

	@Override
	public void update(CatagoryModel catagory) {
		// TODO Auto-generated method stub

		CatagoryModel cate = this.findByName(catagory.getCatagoryname());

		if (cate != null) {
			catagoryDao.update(catagory);
		}

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

		catagoryDao.delete(id);
	}

	@Override
	public void updateStatus(int id, int status) {
		// TODO Auto-generated method stub
		
		catagoryDao.updateStatus(id, status);
	}

}
