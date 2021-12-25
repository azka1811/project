package application;

public abstract class PaymentHandler {

	public PaymentHandler(){
		
		System.out.println("CREATED pAYMENT HANDLER");
	}
	public abstract float MakePayment(float Total,float paidAmount);
}
