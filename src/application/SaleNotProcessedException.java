package application;

public class SaleNotProcessedException extends Exception {
	SaleNotProcessedException(String msg) {
		System.out.println(msg);
	}
}
