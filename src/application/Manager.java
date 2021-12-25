package application;

import java.io.IOException;

public class Manager {

	private int managerid;
	private String managername;
	private String managerUserName;
	private String managerPassword;
	DBHandler dbhandler;
	public int getManagerid() {
		return managerid;
	}
	public void setManagerid(int managerid) {
		this.managerid = managerid;
	}
	public String getManagername() {
		return managername;
	}
	public void setManagername(String managername) {
		this.managername = managername;
	}
	public String getManagerUserName() {
		return managerUserName;
	}
	public void setManagerUserName(String managerUserName) {
		this.managerUserName = managerUserName;
	}
	public String getManagerPassword() {
		return managerPassword;
	}
	public void setManagerPassword(String managerPassword) {
		this.managerPassword = managerPassword;
	}
	public Manager verifyLogin(String username,String password) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException
	{
		dbhandler=Factory.getInstance().CreateDBHandler();
		return dbhandler.getManager(username, password) ;
		
	}
}
