package api.payload;

import java.util.List;

public class Pet {
	
	int id;
	String name;
	String status;
	PetCategory category; 	
	Object[] tags;
	String [] photoUrls;
	
	
	public String[] getPhotoUrls() {
		return photoUrls;
	}
	public void setPhotoUrls(String[] photoUrls) {
		this.photoUrls = photoUrls;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Object[] getTags() {
		return tags;
	}
	public void setTags(Object[] tags) {
		this.tags = tags;
	}	
	public PetCategory getCategory() {
		return category;
	}
	public void setCategory(PetCategory category) {
		this.category = category;
	}
	
}
