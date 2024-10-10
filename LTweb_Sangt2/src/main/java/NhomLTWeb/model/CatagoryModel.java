package NhomLTWeb.model;

public class CatagoryModel {
	
	private int catagoryID;
	private String catagoryname;
	private String images;
	private int status;
	
	
	
	
	
	
	
	public CatagoryModel(int catagoryID, String catagoryname, String images, int status) {
		super();
		this.catagoryID = catagoryID;
		this.catagoryname = catagoryname;
		this.images = images;
		this.status = status;
	}
	
	
	
	public CatagoryModel() {
		super();
	}



	public int getCatagoryID() {
		return catagoryID;
	}
	public void setCatagoryID(int catagoryID) {
		this.catagoryID = catagoryID;
	}
	public String getCatagoryname() {
		return catagoryname;
	}
	public void setCatagoryname(String catagoryname) {
		this.catagoryname = catagoryname;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
}
