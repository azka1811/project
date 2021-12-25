package application;
import java.text.SimpleDateFormat;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
public class Receipt {
	static int num=-11212;
	private int ReceiptNumber;
	private String SoldDate;
	private Sale sale;
	private DBHandler DbHandler ;
	public Receipt(){	
		ReceiptNumber=num;
		num+=1;		
		SoldDate=this.setDate();
		
	}
	public Receipt(Sale s){	
		ReceiptNumber=num;
		num+=1;		
		SoldDate=this.setDate();
		sale=s;
		
	}
	
	
	public String getDate() {
		return SoldDate;
	}

	public String setDate() {
		 Date date = new Date();
	     SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
	     String str = formatter.format(date);
	     SoldDate=str;
	     System.out.print("Current date: "+str);
	     return str;
	}

	public Sale getSale() {
		return sale;
	}

	public void setSale(Sale sale) {
		this.sale = sale;
	}


	public int getReceiptNumber() {
		return ReceiptNumber;
	}

	public void setReceiptNumber(int receiptNumber) {
		ReceiptNumber = receiptNumber;
	}


	public Sale GetReceiptSale(int receiptNumber) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		
		setDbHandler(Factory.getInstance().CreateDBHandler());
		//Load Receipt and return the sale 
		
		return sale;
	
	}
	

	public DBHandler getDbHandler() {
		return DbHandler;
	}


	public void setDbHandler(DBHandler dbHandler) {
		DbHandler = dbHandler;
	}
}
