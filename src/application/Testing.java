package application;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

class Testing {

	@Before
	Pharmacy pharmacy=new Pharmacy();
	@Test
	void testLoginSalesPerson() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
	assertTrue(pharmacy.SalesPersonLogin("off", "aunoff"));
	}
	@Test
	void testLoginSalesPersonFails() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
	assertTrue(pharmacy.SalesPersonLogin("off", "aunof"));
	}
	
	@Test
	void testLoginManager() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
	assertTrue(pharmacy.ManagerLogin("Wasay1", "1234"));
	}
	@Test
	void testLoginManagerFails() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
	assertTrue(pharmacy.ManagerLogin("off", "aunof"));
	}
	
	@Test
	void TestEnterProduct()
	{
		//pharmacy.StartSale();
		
		assertEquals(12432.0,pharmacy.EnterProduct(1, 999));
		
	}
	@Test
	void TestPharmacyName()
	{
		String s="Pharmacy";
		assertEquals(s,pharmacy.getPharmacyName());
		
	}
	@Test
	void TestMedicineList()
	{
		assertEquals(1,pharmacy.getMedicineList().get(0).getID());
	}
	@Test
	void TestCatalog() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException
	{
		assertEquals("ponston",pharmacy.getMedicineCatalog().Catalog.get(0).getName());
	}
	@Test
	void TestCatalogNegative() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException
	{
		assertEquals("panadol",pharmacy.getMedicineCatalog().Catalog.get(0).getName());
	}
	
	void TestSales()
	{
		assertEquals(1,pharmacy.salesRecord.SalesList);
	}
	

}
