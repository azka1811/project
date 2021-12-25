package application;
import java.io.*;



public class Factory {
private static Factory factory=null;
private static PaymentHandler paymentHandler=null;
private static DBHandler dbHandler;

public PaymentHandler CreatePaymentHandler(String type) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
	if (paymentHandler==null) {
		
		//payment=(Payment) Class.forName(type).newInstance();		
		if (type=="CashPayment") {		
			paymentHandler =new CashPayment();
			
			
		}
		
	}	
	return (PaymentHandler) paymentHandler;
}
public DBHandler CreateDBHandler() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
	if (dbHandler==null) {
		
		File file = new File(
	            "C:\\Users\\Dell\\Desktop\\sdaProject\\i190423_i190453_i190548\\src\\application\\Properties");
	 
	        
	        BufferedReader br
	            = new BufferedReader(new FileReader(file));
	 
	       
	        String st = "";
	        st = br.readLine();
	 
	        
	            System.out.println(st);
	        if(st.equals("MySQL"))
	        {
	        	dbHandler=new MySQL();
	        }
	       
	}	
	return (DBHandler) dbHandler;
}



public static Factory getInstance() {
	// TODO Auto-generated method stub
	if (factory==null){
		factory=new Factory();	
	}
	return factory;
}
}
