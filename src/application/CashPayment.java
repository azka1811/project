package application;

public class CashPayment extends PaymentHandler {
		
	public CashPayment(){
		
		
	}
	public float  MakePayment(float Total,float PaidCash) {
		 	
		 System.out.println("Payment by Cash "+Total );
		// System.out.println("Payment by Cash");
		 
		 return PaidCash-Total;
	 }
}
