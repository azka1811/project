package application;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class SampleController  {
	int a = 0;
	float x;
	@FXML

	private TextField UserField;
	@FXML
	private PasswordField PasswordTextField;
	@FXML
	private Button LoginAsManager;
	@FXML
	private Button LoginAsSalesPerson;
	@FXML
	private Label SuccessField;
	@FXML
	private AnchorPane rootPane;
	@FXML
	private TextField medicineID;
	@FXML
	private Button AddMedicineButton;
	@FXML
	private Button DeleteMedicineButton;
	@FXML
	private Button ViewMedicinesButton;
	@FXML
	private TextField medicineName;
	@FXML
	private TextField medicineDescription;
	@FXML
	private TextField medicinePrice;
	@FXML
	private Button AddButton;
	@FXML
	private Button BackButtonManagerView;
	@FXML
	private Label medicineAddedSuccessfully;
	@FXML
	private Button backFromViewSales;
	@FXML
	private Button backDeleteMedicine;
	@FXML
	private Button backFromAddMedicine;
	@FXML
	private Button StartNewSaleButton;
	@FXML
	private TextField NewSaleMedicineID;
	@FXML
	private TextField NewSaleMedicineName;
	@FXML
	private TextField NewSaleMedicineQty;
	@FXML
	private TextField NewSaleMedicinePrice;
	@FXML
	private Date dateFieldNewSale;
	@FXML
	private TextField NewSalePaymentMethod;
	@FXML
	private Button AddNewSaleButton;
	@FXML
	private Button Return;
	@FXML
	private Label Reciept;
	@FXML
	private Button ViewSalesButtonSalesPerson;
	@FXML
	private Button BackFromSalesPerson;
	@FXML
	private Button BackFromAddNewSale;
	@FXML
	private Button BackFromReturnItem;
	@FXML
	private Button BackFromViewSalesAsSalesPerson;
	@FXML
	private ListView tbl;
	@FXML
	private ListView tableSales;
	@FXML
	private Button seecatalog;
	@FXML
	private Button clicktoviewsales;
	@FXML
	private DatePicker fromDate;
	@FXML
	private DatePicker toDate;
	@FXML
	private Button add;
	@FXML
	private Button remove;
	@FXML
	private Button catalogview;
	@FXML
	private Button ViewCatalogButton;
	@FXML
	private Button backfromcatalog;
	@FXML
	private Button addsalemedicine;
	@FXML
	private Label total;
	@FXML
	private Label amountdue;
	@FXML
	private Label amountremaining;
	@FXML
	private TextField amountgiven;
	@FXML
	private Button closesale;
	@FXML
	private Button clicktopay;
	@FXML
	private Button enter;
	@FXML
	private Label ReceiptButton;
	@FXML
	private ListView tablereceipt;
	@FXML
	private Button generatereceipt;
	static Pharmacy pharmacy = new Pharmacy();
	ObservableList<Medicine> MedicineTable = FXCollections.observableArrayList();

	public void BackFunc(String fxmlFile, Button b1)
			throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {

		Stage window = new Stage();
		BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource(fxmlFile));
		Scene scene = new Scene(root, 600, 600);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		window = (Stage) b1.getScene().getWindow();
		window.setScene(scene);
		window.show();
	}
     Sale sale=new Sale();
     
	public void NewWindow(String fxmlFileName, Button b) throws IOException {
		Stage window = new Stage();
		BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource(fxmlFileName));
		Scene scene = new Scene(root, 600, 600);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		window = (Stage) b.getScene().getWindow();
		window.setScene(scene);
		window.show();
	}

	public void backfromcatalog()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		BackFunc("loginAsManagerView.fxml", backfromcatalog);
	}

	public void loginAsManagerFunc() throws IOException // throws IOException
			, InstantiationException, IllegalAccessException, ClassNotFoundException {

		if (pharmacy.ManagerLogin(UserField.getText(), PasswordTextField.getText())) {

			SuccessField.setText("Login Successful");
			NewWindow("LoginAsManagerView.fxml", LoginAsManager);
		} else {
			SuccessField.setText("User Name or Password incorrect");
		}

	}

	public void addNewMedicineFunc() throws IOException {

		NewWindow("AddSale.fxml", AddMedicineButton);

	}

	public void clicktopayfunc1() throws IOException {
		NewWindow("Payment.fxml", clicktopay);
	}

	public void viewCatalogFunc() throws IOException {
		NewWindow("vewcatalog.fxml", catalogview);
	}

	public void DeleteMedicine() throws IOException {
		NewWindow("DeleteMedicine.fxml", DeleteMedicineButton);

	}

	public void ViewSales() throws IOException {
		NewWindow("ViewSales.fxml", ViewMedicinesButton);
	}

	public void ViewSalesAsSalesPerson() throws IOException {
		NewWindow("viewSalesAsSalesPerson.fxml", ViewSalesButtonSalesPerson);
	}

	public void loginSalesPersonFunc()
			throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {

		if (pharmacy.SalesPersonLogin(UserField.getText(), PasswordTextField.getText())) {

			NewWindow("LoginAsSalesPersonView.fxml", LoginAsSalesPerson);

		} else {
			SuccessField.setText("User Name or Password incorrect");
		}
	}

	public void backFromManagerFunc()
			throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		BackFunc("Sample.fxml", BackButtonManagerView);
	}

	public void backFromAddMedicineFunc()
			throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		BackFunc("loginAsManagerView.fxml", backFromAddMedicine);
	}

	public void backFromDeleteMedicineFunc()
			throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		BackFunc("loginAsManagerView.fxml", backDeleteMedicine);
	}

	public void backFromViewSale()
			throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		BackFunc("loginAsManagerView.fxml", backFromViewSales);
	}

	public void StartNewSaleButton() throws IOException {
		NewWindow("StartNewSales.fxml", StartNewSaleButton);

	}

	String NMedicineID;
	String NMedicineName;
	String MedicineQty;
	String NMedicinePrice;
	String NPaymentMethod;

	public void AddNewSaleButtonFunc() {
		NMedicineID = NewSaleMedicineID.getText();
		NMedicineName = NewSaleMedicineName.getText();
		MedicineQty = NewSaleMedicineQty.getText();
		NMedicinePrice = NewSaleMedicinePrice.getText();
		NPaymentMethod = NewSalePaymentMethod.getText();

		Reciept.setText(" ID \t\t Name \t\t Qty \t\t Total \r\n " + NMedicineID + "\t\t" + NMedicineName + "\t\t"
				+ MedicineQty + "\t\t" + NPaymentMethod);

	}

	public void HandleReturn() throws IOException {
		NewWindow("Return.fxml", Return);
	}

	public void BackFromSalesPersonView()
			throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		BackFunc("Sample.fxml", BackFromSalesPerson);
	}

	public void BackFromReturnSaleButtonFunc()
			throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		BackFunc("loginAsSalesPersonView.fxml", BackFromReturnItem);
	}

	public void BackFromViewSalesButtonFunc()
			throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		BackFunc("LoginAsSalesPersonView.fxml", BackFromViewSalesAsSalesPerson);
	}

	public void BackFromAddNewSaleButtonFunc()
			throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		BackFunc("LoginAsSalesPersonView.fxml", BackFromAddNewSale);
	}

	public void TableShow() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		ArrayList<MedicineDescription> madicine = pharmacy.getMedicineCatalog().getDescription();
		tbl.getItems().add("ID\t\tName\t\tPrice");
		for (int i = 0; i < madicine.size(); i++) {
			// MedicineDescription meds=madicine.get(i).getMedicinedescription();
			tbl.getItems().add(madicine.get(i).getID() + " \t\t" + madicine.get(i).getName() + "\t\t"
					+ madicine.get(i).getPrice());

		}
		
	}

	public void ViewSalesRec()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		tableSales.getItems().clear();
		ArrayList<String> recc = new ArrayList<String>();
		fromDate.getValue();
		String from = "" + fromDate.getValue() + "";
		String to = "" + toDate.getValue() + "";
		recc = pharmacy.getAllSalesRecord(from, to);

		tableSales.getItems().add("saleDate" + "\t\t\t" + "saleID" + "\t\t\t" + "receiptid" + "\t\t\t" + "total");
		for (int i = 0; i < recc.size(); i++) {
			tableSales.getItems().add(recc.get(i));
		}

	}

	public void AddMedicineFunction()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException, MedicineNotAddedSuccessfullyException {
		int medicineid = 0;
		int medicineqty = 0;

		medicineid = Integer.parseInt(medicineID.getText());
		medicineqty = Integer.parseInt(medicineName.getText());
		System.out.println("ID is " + medicineid + " qty is " + medicineqty + " ");
		pharmacy.AddMedicine(medicineid, medicineqty);
		if (medicineName.getText().equals("") || medicineID.getText().equals("")) {
			medicineAddedSuccessfully.setText("Please Provide Complete Information");
		} else {
			throw new MedicineNotAddedSuccessfullyException("medicine not addded");
		}
	}

	public void RemoveMedicineFunction()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		int medicineid = 0;
		int medicineqty = 0;

		medicineid = Integer.parseInt(medicineID.getText());
		medicineqty = Integer.parseInt(medicineName.getText());
		System.out.println("ID is " + medicineid + " qty is " + medicineqty + " ");
		pharmacy.RemoveMedicine(medicineid, medicineqty);
		if (medicineName.getText().equals("") || medicineID.getText().equals("")) {
			medicineAddedSuccessfully.setText("Please Provide Complete Information");
		} else {
			medicineAddedSuccessfully.setText("Medicine Added Successfully");
		}
	}

	public void AddMedicineS()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException, SaleNotProcessedException {
		int newsalemedicineid;
		int newsalemedicineqty;

		if (a == 0) {
			pharmacy.StartSale();
			a++;
		}

		newsalemedicineid = Integer.parseInt(NewSaleMedicineID.getText());
		newsalemedicineqty = Integer.parseInt(NewSaleMedicineQty.getText());
		pharmacy.EnterProduct(newsalemedicineid, newsalemedicineqty);
		x = (pharmacy.EnterProduct(newsalemedicineid, newsalemedicineqty)) / 2;
		total.setText("Total is " + x);
		// pharmacy.StartPayment("CashPayment");
//		float y=pharmacy.MakePayment(x, 5000);
//		pharmacy.closeSale();
		sale=pharmacy.getCurrentSale();
		if(NewSaleMedicineID.getText().equals(""))
		{
			throw new SaleNotProcessedException("sale was unsuccessful");
		}

	}

	public void makePayment() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		int paidamount;
		pharmacy.StartPayment("CashPayment");
		paidamount=Integer.parseInt(amountgiven.getText());
		float j=pharmacy.getCurrentSale().getTotal()/2;
		float i=pharmacy.MakePayment(j, paidamount);
		amountdue.setText("Amount Due = "+j);
		amountremaining.setText("Remaining Amount is = "+ i);
		

	}
	public void closeSale() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException
	{
		NewWindow("closedSale.fxml",closesale);
		
		
	}
	public void receiptgeneratefunction() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException
	{
		Receipt r=pharmacy.closeSale();
		tablereceipt.getItems().add("Date: "+r.getDate());
		tablereceipt.getItems().add("Receipt Number: "+r.getReceiptNumber());
		for(int i=0;i<r.getSale().getSaleLineItems().size();i+=2)
		{
			tablereceipt.getItems().add(r.getSale().getSaleLineItems().get(i).getMedicine().getMedicinedescription().getID()+"\t\t"+r.getSale().getSaleLineItems().get(i).getMedicine().getMedicinedescription().getName()+"\t\t\t"+r.getSale().getSaleLineItems().get(i).getQuantity());
		}
	}
	public void writeinfiles() throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		
		File myObj = new File("desc.txt");
		FileWriter myWriter = new FileWriter("desc.txt");
		ArrayList<MedicineDescription> madicine = pharmacy.getMedicineCatalog().getDescription();
	      for (int i = 0; i < madicine.size(); i++) {
				// MedicineDescription meds=madicine.get(i).getMedicinedescription();
				myWriter.write(madicine.get(i).getID() + " \t\t" + madicine.get(i).getName() + "\t\t"
						+ madicine.get(i).getPrice());

			}
	      myWriter.close();
	}
}
