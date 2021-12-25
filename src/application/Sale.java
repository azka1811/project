package application;
import java.util.ArrayList;  
public class Sale {
private static int IDS=-11212;

private String Date;
private float Total;
private int SaleID;
private Receipt receipt;

private ArrayList<SaleLineItem> saleLineItems;
//private Receipt receipt; 
public String getDate() {
	return Date;
}
public void setDate(String date) {
	Date = date;
}

Sale(){
	saleLineItems=new ArrayList<SaleLineItem>();
	SaleID=IDS;
	IDS+=1;
	Total=0;
	
}
public float EnterItem(Medicine medicine,int quantity ) {
	

	SaleLineItem saleLineItem=new SaleLineItem();
	saleLineItem.EnterItem(medicine, quantity);
	saleLineItems.add(saleLineItem);
	Total+=saleLineItem.getSubTotal();
	return Total;
}

public void AssignNewID() {
	SaleID=IDS;
	IDS+=1;
	
}
public Receipt GenerateReceipt(Sale sale) {
	receipt=new Receipt();
	receipt.setSale(sale);
	return receipt;
	
}


public void UpdateSaleLineItem(int medicineID,int quantity) {
	
	for(int i=0;i<saleLineItems.size();i++) {
		if (saleLineItems.get(i).getMedicine().getMedicinedescription().getID()==medicineID) {
			saleLineItems.get(i).UpdateSaleLineItem(quantity);
			return;
		}		
	}
	
	return;
}

public Sale CopySale() {
	Sale copy=new Sale();
	copy.setSaleID(SaleID);
	copy.setDate(Date);
	copy.setSaleLineItems(saleLineItems);
	copy.setTotal(Total);
	
	return copy;
}

public float getTotal() {
	Total=0;
	for(int i=0;i<saleLineItems.size();i++) {
		Total+=saleLineItems.get(i).getSubTotal();
	}
	
	return Total;
}
public void setTotal(float total) {
	Total = total;
}

public int getSaleID() {
	return SaleID;
}
public void setSaleID(int saleID) {
	SaleID = saleID;
}


public ArrayList<SaleLineItem> getSaleLineItems() {
	return saleLineItems;
}
public void setSaleLineItems(ArrayList<SaleLineItem> saleLineItems) {
	this.saleLineItems = saleLineItems;
}
	
}
