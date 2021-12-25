package application;

public  class Payment {
	private PaymentHandler paymentHandler;
       
	void SetPaymentHandler(PaymentHandler PHandler) {
		
		paymentHandler=PHandler;
	}
	PaymentHandler getPaymentHandler() {
		return paymentHandler;
		
	}
	public Payment() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
	
		//paymentHandler=Factory.getInstance().CreatePaymentHandler("CashPayment");
	}
	
	
	float  MakePayment(float Total,float paidCash) {
		
		return paymentHandler.MakePayment(Total,paidCash);
	}
}
