package NhomLTWeb.controllers.web.Admin;

import java.io.IOException;
import java.util.List;

import NhomLTWeb.model.CatagoryModel;
import NhomLTWeb.services.ICatagoryService;
import NhomLTWeb.services.Implement.CatagoryService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns ={"/admin/catagories", "/admin/catagory/insert", "/admin/catagory/edit"})	

//@MultipartConfig(fileSizeThreshold = )
public class CatagoryController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CatagoryService cateService = new ICatagoryService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		
		
		
		String url = req.getRequestURI();
		if (url.contains("/admin/catagories")) {
			List<CatagoryModel> list = cateService.findAll();
			req.setAttribute("listcate", list);
			req.getRequestDispatcher("/views/admin/catagories-list.jsp").forward(req, resp);
		}
		else if (url.contains("/admin/catagory/add")) {
			req.getRequestDispatcher("views/admin/catagory-add.jsp").forward(req, resp);
		}
		else if (url.contains("/admin/catagory/edit")) {
			int id = Integer.parseInt(req.getParameter("id"));
			CatagoryModel category = cateService.findByID(id);
			req.setAttribute("cate", category);
			req.getRequestDispatcher("views/admin/catagory-edit.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		String url = req.getRequestURI();
		if (url.contains("/admin/catagory/insert")) {
			// lấy dữ liệu từ form
			
			String catagoryname = req.getParameter("catagoryname");
			String images = req.getParameter("images");
			int status = Integer.parseInt(req.getParameter("status"));
			
			// đưa data vào model
			
			CatagoryModel catagory = new CatagoryModel();
			catagory.setCatagoryname(catagoryname);
			catagory.setImages(images);
			catagory.setStatus(status);
			//kiểm tra sự tồn tại của model
			CatagoryModel cate = cateService.findByName(catagoryname);
			if (cate==null) {
				cateService.insert(catagory);
			}
			else {
				System.out.println("Thêm thất bại");
			}
			
			//
			cateService.insert(catagory);
			
			
			//
			resp.sendRedirect(req.getContextPath() + "/admin/categories");
		}
		
		
	}

}
