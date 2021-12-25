package application;

import java.io.IOException;
import java.util.ArrayList;

public class Pharmacy {

	private String PharmacyName;
	private String Address;
	private Sale CurrentSale;
	private ArrayList<Sale> sales;
	private MedicineCatalog medicineCatalog;
	private ArrayList<Medicine> medicines;
	private Receipt receipt;
	public Payment payment;
	public SaleRecord salesRecord;
	private RevertedSale revertedSale;
	private SalesPerson salesperson;
	private Manager manager;

	public Pharmacy() {
		medicineCatalog = new MedicineCatalog();
		salesRecord = new SaleRecord();
		try {
			medicines = Factory.getInstance().CreateDBHandler().getAllMedicines();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Load all Medicines

	}

	public Sale getSale(int receiptNumber)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		receipt = new Receipt();
		CurrentSale = receipt.GetReceiptSale(receiptNumber);

		return CurrentSale;

	}

	public void StartSale() {
		CurrentSale = new Sale();

	}

	void AddRevertedSale(int saleId)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		revertedSale.AddRevertedSale(saleId);
		CurrentSale.AssignNewID();
	}

	public Receipt EndMedicineReturn() {

		return receipt;

	}

	public float EnterProduct(int medicineId, int quantity) {

		for (int i = 0; i < medicines.size(); i++) {
			// Medicine medicine=medicinmedicineCatalog.GetDescription(medicineId);
			if (medicines.get(i).getMedicinedescription().getID() == medicineId) {

				float Total = CurrentSale.EnterItem(medicines.get(i), quantity);
				return Total;
			}

		}

		return 0;

	}

	public MedicineCatalog getMedicineCatalog()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		medicineCatalog = new MedicineCatalog();
		medicineCatalog.getAllMedicines();
		return medicineCatalog;

	}

	public ArrayList<MedicineDescription> getAllMedicines() {

		return medicineCatalog.getDescription();

	}

	public void UpdateSaleLineItem(int MedicineId, int Quantity) {
		float lastPaid = CurrentSale.getTotal();
		CurrentSale.UpdateSaleLineItem(MedicineId, Quantity);
		float newTotal = CurrentSale.getTotal();
		float RefundedAmount = lastPaid - newTotal;

	}

	public void StartPayment(String type)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		payment = new Payment();
		payment.SetPaymentHandler(Factory.getInstance().CreatePaymentHandler(type));
	}

	public Receipt closeSale()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {

		salesRecord.RecordSale(CurrentSale);
		return CurrentSale.GenerateReceipt(CurrentSale);
	}

	public String getPharmacyName() {
		return PharmacyName;
	}

	public void setPharmacyName(String pharmacyName) {
		PharmacyName = pharmacyName;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public float MakePayment(float Total, float paidCash) {

		return payment.MakePayment(Total, paidCash);
	}


	public Sale getCurrentSale() {
		return CurrentSale;
	}

	public void setCurrentSale(Sale currentSale) {
		CurrentSale = currentSale;
	}

	public RevertedSale getRevertedSale() {
		return revertedSale;
	}

	public void setRevertedSale(RevertedSale revertedSale) {
		this.revertedSale = revertedSale;
	}

	public boolean SalesPersonLogin(String username, String password)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {

		salesperson = new SalesPerson();

		salesperson = salesperson.verifyLogin(username, password);
		if (salesperson != null) {
			return true;
		}
		return false;
	}

	public boolean ManagerLogin(String username, String password)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {

		manager = new Manager();

		manager = manager.verifyLogin(username, password);
		if (manager != null) {
			return true;
		}
		return false;
	}

	public ArrayList<Medicine> getMedicineList() {
		return this.medicines;
	}

	ArrayList<String> getAllSalesRecord(String from, String to)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		return salesRecord.getAllSales(from, to);
	}

	public void AddMedicine(int medicineID, int quantity) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		for (int i = 0; i < medicines.size(); i++) {
			if (medicines.get(i).getID() == medicineID) {
				medicines.get(i).addMedicine(medicineID, quantity);
				return;
			}
			
		}
		System.out.println("ID = "+medicineID+"");
	}

	public void RemoveMedicine(int medicineID, int quantity) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		for (int i = 0; i < medicines.size(); i++) {
			if (medicines.get(i).getID() == medicineID) {
				medicines.get(i).RemoveMedicine(medicineID, quantity);
				return;
			}
			
		}
		System.out.println("ID = "+medicineID+"");
		
	}
}
