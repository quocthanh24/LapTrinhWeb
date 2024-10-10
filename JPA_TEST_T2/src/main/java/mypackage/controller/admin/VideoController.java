package mypackage.controller.admin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import mypackage.entity.Category;
import mypackage.entity.Video;
import mypackage.service.IVideoService;
import mypackage.service.impl.CategoryService;
import mypackage.service.impl.VideoService;
import mypackage.utils.Constant;

@MultipartConfig(fileSizeThreshold = 1024 * 1024,
    maxFileSize = 1024 * 1024 * 50, // Tăng giới hạn file để phù hợp với video lớn hơn
    maxRequestSize = 1024 * 1024 * 50 * 5)
@WebServlet(urlPatterns = { "/admin/videos", "/admin/video/add", "/admin/video/edit", 
							"/admin/video/insert","/admin/video/update", "/admin/video/delete"})
public class VideoController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    IVideoService videoService = new VideoService();
    String categoryid = "";
    
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String url = req.getRequestURI();

        if (url.contains("videos")) {
            List<Video> list = videoService.findAll();
            req.setAttribute("listvideo", list);
            req.getRequestDispatcher("/views/admin/video-list.jsp").forward(req, resp);

        } else if (url.contains("/admin/video/edit")) {
            int id = Integer.parseInt(req.getParameter("id"));
            Video video = videoService.findById(id);
            req.setAttribute("video", video);
            req.getRequestDispatcher("/views/admin/video-edit.jsp").forward(req, resp);

        } else if (url.contains("/admin/video/add")) {
        	List<Video> list = videoService.findAll();
            req.setAttribute("listVideo", list);
            req.getRequestDispatcher("/views/admin/video-add.jsp").forward(req, resp);

        } else if (url.contains("/admin/video/delete")) {
            int id = Integer.parseInt(req.getParameter("id"));
            try {
                videoService.delete(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
            resp.sendRedirect(req.getContextPath() + "/admin/videos");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String url = req.getRequestURI();
        
        
        if (url.contains("/admin/video/insert")) {
            
        	
        	// Lấy dữ liệu từ tham số
            String videoid = req.getParameter("videoid");
            int active = Integer.parseInt(req.getParameter("active"));
            String description = req.getParameter("description");
            String poster = req.getParameter("poster");
            String title = req.getParameter("title");
            int views = Integer.parseInt(req.getParameter("views"));
            int categoryid = Integer.parseInt(req.getParameter("categoryid"));
            
            
            // Set dữ liệu vào entity
            
            Video video = new Video();
			video.setVideoId(videoid);
			video.setActive(active);
			video.setDescription(description);
			video.setPoster(poster);
			video.setTitle(title);
			video.setViews(views);
			
			
			// Set category có trùng giá trị id vào data
			CategoryService cateService = new CategoryService();
			Category category = cateService.findById(categoryid);
			video.setCategory(category);
			
            String fname = "";
            String uploadPath = Constant.UPLOAD_DIRECTORY;

            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            try {
                Part part = req.getPart("poster");
                if (part.getSize() > 0) {
                    String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
                    // Đổi tên file video
                    int index = filename.lastIndexOf(".");
                    String ext = filename.substring(index + 1);
                    fname = System.currentTimeMillis() + "." + ext;
                    // Upload video
                    part.write(uploadPath + "/" + fname);
                    // Ghi tên file vào data
                    video.setPoster(fname);
                } else {
                	// Set default poster
                    video.setPoster("https://tse3.mm.bing.net/th?id=OIP.99qJd0KiYicICEzUQ8l13wAAAA&pid=Api&P=0&h=220");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            videoService.insert(video);
            resp.sendRedirect(req.getContextPath() + "/admin/video?id=" + categoryid);
        }
        else if (url.contains("/admin/video/update")) {
        	 String videoID = req.getParameter("videoid");
             int active = Integer.parseInt(req.getParameter("active"));
             int views = Integer.parseInt(req.getParameter("views"));

             Video video = new Video();
             video.setVideoId(videoID);
             video.setDescription(req.getParameter("description"));
             video.setTitle(req.getParameter("title"));
             video.setViews(views);
             video.setActive(active);

             String fname = "";
             String uploadPath = Constant.UPLOAD_DIRECTORY;
             File uploadDir = new File(uploadPath);
             if(!uploadDir.exists()){
                 uploadDir.mkdir();
             }
             try{
                 Part part = req.getPart("images");
                 if (part.getSize() > 0) {
                     String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
                     //Doi ten file
                     int index = fileName.lastIndexOf(".");
                     String ext = fileName.substring(index + 1);
                     fname = System.currentTimeMillis() + "." + ext;
                     part.write(uploadPath + "/" + fname);
                     //ghi ten file vao data
                     video.setPoster(fname);
                 }
                 else{
                	 // Set default poster 
                     video.setPoster("https://tse3.mm.bing.net/th?id=OIP.99qJd0KiYicICEzUQ8l13wAAAA&pid=Api&P=0&h=220");
                 }
             }
             catch (Exception e){
                 e.printStackTrace();
             }
             videoService.update(video);
             resp.sendRedirect(req.getContextPath() + "/admin/videos?id=" + categoryid);
        }
    }
}

