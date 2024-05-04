package api.payload;

import java.util.Date;

public class Store {
	
	int id;
	int petId;
	int quantity;
	Date shipDate;
	String status;
	boolean complete;
	
	
	public Date getShipDate() {
		return shipDate;
	}
	public void setShipDate(Date date) {
		this.shipDate = date;
	}	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPetId() {
		return petId;
	}
	public void setPetId(int petId) {
		this.petId = petId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public boolean getComplete() {
		return complete;
	}
	public void setComplete(boolean complete) {
		this.complete = complete;
	}
}
