package mypackage.entity;

import java.io.Serializable;
import java.util.List;

//import jakarta.annotation.Generated;
import jakarta.persistence.*;
//import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "categories")
@AllArgsConstructor
@NoArgsConstructor
@Data
@NamedQuery(name = "Category.findAll", query = "Select c from Category c")
public class Category implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CategoryId")
	private int categoryid;

	@Column(name = "Categoryname", columnDefinition = "nvarchar(150) NOT NULL")
	@NotEmpty(message = "Không được bỏ trống")
	private String categoryname;

	@Column(name = "Images", columnDefinition = "nvarchar(500) NULL")
	private String images;

	@Column(name = "Status")
	private int status;

	// bi-directional many-to-one association to Video

	@OneToMany(mappedBy = "category")
	private List<Video> videos;


	
	
	
	
	
	public Video addVideo(Video video) {
		getVideos().add(video);
		video.setCategory(this);
		return video;

	}

	public Video removeVideo(Video video) {
		getVideos().remove(video);
		video.setCategory(null);
		return video;

	}

	public List<Video> getVideos() {
		return videos;
	}

	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}

	public Category() {
		super();
	}

	public int getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
