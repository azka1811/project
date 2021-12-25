package application;
import java.io.IOException;
import java.util.ArrayList;  


public class MedicineCatalog {
	ArrayList<MedicineDescription> Catalog ;
	DBHandler dbhandler;
	
	MedicineCatalog(){
		Catalog=new ArrayList<MedicineDescription>();
		//DummyCatalog();
	}
	
	MedicineDescription GetDescription (int id ) {
		for (int i=0;i<Catalog.size();i++) {
			
			if (Catalog.get(i).getID()==id) {
				return Catalog.get(i);
				
			}
		}
		return null;
				
		
	}
	
	
	
	void DummyCatalog() {
		MedicineDescription add=new MedicineDescription("a",100,"useless","Narcotic",100);
		MedicineDescription ad2=new MedicineDescription("b",101,"Not useless","not Narcotic",200);
		Catalog.add(add);
		Catalog.add(ad2);
		
	}
	public void DisplayCatalog() {
			for(int i=0;i<Catalog.size();i++) {
				System.out.println("Medicine "+ i);
				System.out.println("Name "+ Catalog.get(i).getName());
				System.out.println("ID "+ Catalog.get(i).getID());
				System.out.println("Description "+ Catalog.get(i).getDescription());
				System.out.println("Type "+ Catalog.get(i).getType());
				System.out.println("Price "+ Catalog.get(i).getPrice());
			}
	}
	
	public void addMedicine(MedicineDescription Description) {
		
	}

	public void getAllMedicines() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		dbhandler=Factory.getInstance().CreateDBHandler();
		this.Catalog=dbhandler.viewCatalog();
	}
		
	public ArrayList<MedicineDescription> getDescription()
	{
		return this.Catalog;
	}
}
