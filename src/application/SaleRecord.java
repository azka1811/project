package application;
import java.io.IOException;
import java.util.ArrayList;  
public class SaleRecord {

	DBHandler SaleDbHandler;
	ArrayList<Integer> SalesList;
	
	public SaleRecord() {
		
		SalesList=new ArrayList<Integer>();
		
	}
	
	public void RecordSale(Sale sale) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		
	SaleDbHandler=Factory.getInstance().CreateDBHandler();
		
		SalesList.add(sale.getSaleID());
	SaleDbHandler.RecordSale(sale);
	
	
	System.out.println("Sale placed in DB ");
	 
	
	}

	public ArrayList<String> getAllSales(String from, String to) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		SaleDbHandler=Factory.getInstance().CreateDBHandler();
	
		return SaleDbHandler.getSaleRecord(from, to);
	}
	
	
}
