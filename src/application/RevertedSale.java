package application;
import java.io.IOException;
import java.util.ArrayList;  
public class RevertedSale {
private ArrayList<Integer> revertedSales;// Storing only the IDS of Reverted SALES
private DBHandler DbHandler;
public void  AddRevertedSale(int SaleId) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
	
	revertedSales.add(SaleId);
	DbHandler=Factory.getInstance().CreateDBHandler();
	
	// Modify Sale AS reverted DB code
	
}
public ArrayList<Integer> getRevertedSales() {
	return revertedSales;
}
public void setRevertedSales(ArrayList<Integer> revertedSales) {
	this.revertedSales = revertedSales;
}
public DBHandler getDbHandler() {
	return DbHandler;
}
public void setDbHandler(DBHandler dbHandler) {
	DbHandler = dbHandler;
}
	
}
