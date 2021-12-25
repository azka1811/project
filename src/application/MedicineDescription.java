package application;

public class MedicineDescription {
private String Name;
private int ID;
private String Description;
private String Type;
private float Price;

public MedicineDescription(String name,int id,String description, String type,float price) {
Name=name;
ID=id;
Description=description;
Type=type;
Price=price;
}

public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public int getID() {
	return ID;
}
public void setID(int iD) {
	ID = iD;
}

public String getDescription() {
	return Description;
}
public void setDescription(String description) {
	Description = description;
}
public String getType() {
	return Type;
}
public void setType(String type) {
	Type = type;
}

public float getPrice() {
	return Price;
}

public void setPrice(float price) {
	this.Price = price;
}
	
}
