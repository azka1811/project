package application;

public class SaleLineItem {

	private int Quantity;
	private Medicine  medicine;
	
	public int getQuantity() {
		return Quantity;
	}
	
	
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public void UpdateSaleLineItem(int quantity) {
		Quantity=quantity;
		
	}
	
	public float getSubTotal() {
		return medicine.getMedicinedescription().getPrice()*Quantity;
	}

	public Medicine getMedicine() {
		return medicine;
	}

	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}


	public void EnterItem(Medicine medicine2, int quantity) {
		this.medicine=medicine2;
		this.Quantity=quantity;
		
	}
	

}
