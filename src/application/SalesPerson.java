package application;

import java.io.IOException;

public class SalesPerson {
	private int UserID;
	private String name;
	private String username;
	private String password;
	DBHandler dbhandler=new MySQL();
	
	public int getUserID() {
		return UserID;
	}
	public void setUserID(int userID) {
		UserID = userID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public SalesPerson verifyLogin(String username,String password) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException
	{
		dbhandler=Factory.getInstance().CreateDBHandler();
		return dbhandler.getSalesPerson(username, password) ;
		
	}

}
