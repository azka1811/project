package application;

import java.io.IOException;

public class Medicine {

	private MedicineDescription medicinedescription;
	private int id;
	DBHandler DbHandler;
	
	public MedicineDescription getMedicinedescription() {
		return medicinedescription;
	}
	public void setMedicinedescription(MedicineDescription medicinedescription) {
		this.medicinedescription = medicinedescription;
	}
	public int getID() {
		return id;
	}
	public void setID(int stock) {
		this.id = stock;
	}
	
	void addMedicine(int MedicineId, int quantity) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		
		DbHandler=Factory.getInstance().CreateDBHandler();
		DbHandler.AddMedicine(MedicineId, quantity);
		// send query to add medicine
	}
	public void RemoveMedicine(int medicineID, int quantity) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		DbHandler=Factory.getInstance().CreateDBHandler();
		DbHandler.RemoveMedicine(medicineID, quantity);
	}
	
	
}

