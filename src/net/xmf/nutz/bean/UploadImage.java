package net.xmf.nutz.bean;

import java.util.Date;

import org.nutz.dao.entity.annotation.Id;

public class UploadImage {
	
	@Id
	private Long id;
	
	private String imageName;
	
	private String imagePath;
	
	private String imageDescri;
	
	private Long userId;
	
	private Date uploadDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getImageDescri() {
		return imageDescri;
	}

	public void setImageDescri(String imageDescri) {
		this.imageDescri = imageDescri;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}
	
	
	
}
