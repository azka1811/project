package application;

import java.sql.Date;
import java.util.ArrayList;

public abstract class DBHandler {

	public abstract void RecordSale(Sale sale);
	public ArrayList<MedicineDescription> medicineCatalog=new ArrayList<MedicineDescription>();
	public abstract ArrayList<MedicineDescription> viewCatalog();
	public abstract void AddMedicine(int medicineID,int qty);
	public abstract void RemoveMedicine(int medicineID,int qty);
	public abstract void AddMedicineHistory(int managerId, int medicineID, int quantity, String type);
	public abstract Receipt GenerateReceipt(Sale  sale);
	public abstract ArrayList<Medicine> getAllMedicines();
	public ArrayList<Medicine> AllMedicines=new ArrayList<Medicine>();
	public abstract SalesPerson getSalesPerson(String UserName,String Password);
	public abstract Manager getManager(String UserName,String Password);
	public abstract ArrayList<String> getSaleRecord( String from, String to);
	
	
}
