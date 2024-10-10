package NhomLTWeb.dao.Implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import NhomLTWeb.config.DBConnectionMySQL;
import NhomLTWeb.dao.ICatagoryDao;
import NhomLTWeb.model.CatagoryModel;

public class CatagoryDaoImpl implements ICatagoryDao {

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	@Override
	public List<CatagoryModel> findAll() {
		// TODO Auto-generated method stub
		String sql = "Select * from SanPham";
		List<CatagoryModel> list = new ArrayList<>();

		try {
			new DBConnectionMySQL();
			conn = DBConnectionMySQL.getDBConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				CatagoryModel catagory = new CatagoryModel();
				catagory.setCatagoryID(rs.getInt("catagoryID"));
				catagory.setCatagoryname(rs.getString("catagoryID"));
				catagory.setImages(rs.getString("catagoryID"));
				catagory.setStatus(rs.getInt("status"));

				list.add(catagory);
			}

			conn.close();
			ps.close();
			rs.close();
			return list;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public CatagoryModel findByID(int id) {
		// TODO Auto-generated method stub

		String sql = "Select * from SanPham WHERE catagoryID = ?";
		CatagoryModel catagory = new CatagoryModel();
		try {
			new DBConnectionMySQL();
			conn = DBConnectionMySQL.getDBConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();

			while (rs.next()) {
				catagory.setCatagoryID(rs.getInt("catagoryID"));
				catagory.setCatagoryname(rs.getString("catagoryname"));
				catagory.setImages(rs.getString("images"));
				catagory.setStatus(rs.getInt("status"));

			}

			conn.close();
			ps.close();
			rs.close();
			return catagory;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return null;

	}

	@Override
	public CatagoryModel findByName(String name) {
		// TODO Auto-generated method stub

		String sql = "Select * from SanPham WHERE catagoryname = ?";
		CatagoryModel catagory = new CatagoryModel();
		try {
			new DBConnectionMySQL();
			conn = DBConnectionMySQL.getDBConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();

			while (rs.next()) {
				catagory.setCatagoryID(rs.getInt("catagoryID"));
				catagory.setCatagoryname(rs.getString("catagoryname"));
				catagory.setImages(rs.getString("images"));
				catagory.setStatus(rs.getInt("status"));

			}

			conn.close();
			ps.close();
			rs.close();
			return catagory;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<CatagoryModel> searchByName(String keyword) {
		// TODO Auto-generated method stub

		String sql = "Select * from SanPham WHERE catagory name LIKE ?";
		List<CatagoryModel> list = new ArrayList<>();

		try {
			new DBConnectionMySQL();
			conn = DBConnectionMySQL.getDBConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + keyword + "%");
			rs = ps.executeQuery();

			while (rs.next()) {
				CatagoryModel catagory = new CatagoryModel();
				catagory.setCatagoryID(rs.getInt("catagoryID"));
				catagory.setCatagoryname(rs.getString("catagoryID"));
				catagory.setImages(rs.getString("catagoryID"));
				catagory.setStatus(rs.getInt("status"));

				list.add(catagory);
			}

			conn.close();
			ps.close();
			rs.close();
			return list;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void insert(CatagoryModel catagory) {
		// TODO Auto-generated method stub

		String sql = "INSERT INTO SanPham(catogoryname, images, status) " + "VALUE (?,?,?)";

		try {
			new DBConnectionMySQL();
			conn = DBConnectionMySQL.getDBConnection();
			ps = conn.prepareStatement(sql);

			// Truyền tham số vào lệnh truy vấn
			ps.setString(1, catagory.getCatagoryname());
			ps.setString(2, catagory.getImages());
			ps.setInt(3, catagory.getStatus());
			ps.executeUpdate();

			conn.close();
			ps.close();
			rs.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	@Override
	public void update(CatagoryModel catagory) {
		// TODO Auto-generated method stub

		String sql = "UPDATE SanPham SET catogoryname=?, images=?, status=? WHERE catagoryID = ?";

		try {
			new DBConnectionMySQL();
			conn = DBConnectionMySQL.getDBConnection();
			ps = conn.prepareStatement(sql);

			// Truyền tham số vào lệnh truy vấn
			ps.setString(1, catagory.getCatagoryname());
			ps.setString(2, catagory.getImages());
			ps.setInt(3, catagory.getStatus());
			ps.setInt(4, catagory.getCatagoryID());
			ps.executeUpdate();

			conn.close();
			ps.close();
			rs.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
		String sql = "Delete From SanPham Where catagoryID = ?";

		try {
			new DBConnectionMySQL();
			conn = DBConnectionMySQL.getDBConnection();
			ps = conn.prepareStatement(sql);

			// Truyền tham số vào lệnh truy vấn
			ps.setInt(1, id);
			ps.executeUpdate();

			conn.close();
			ps.close();
			rs.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	public void updateStatus(int id, int status) {
		
		String sql = "UPDATE SanPham SET status=? WHERE catagoryID = ?";

		try {
			new DBConnectionMySQL();
			conn = DBConnectionMySQL.getDBConnection();
			ps = conn.prepareStatement(sql);

			// Truyền tham số vào lệnh truy vấn
			ps.setInt(1, status);
			ps.setInt(2, id);
			ps.executeUpdate();

			conn.close();
			ps.close();
			rs.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
