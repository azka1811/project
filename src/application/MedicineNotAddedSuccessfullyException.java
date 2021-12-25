package application;

public class MedicineNotAddedSuccessfullyException extends Exception 
{
	
	MedicineNotAddedSuccessfullyException(String msg)
	{
		System.out.println(msg);
	}
}
