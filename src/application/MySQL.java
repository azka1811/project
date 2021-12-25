package application;
import java.sql.*;
import java.util.ArrayList;
public  class MySQL extends DBHandler {

	@Override
	public void RecordSale(Sale sale) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {

			e1.printStackTrace();
		}
		Connection con;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sda", "root", "wotever");
			
            
             String sql;
             sql="insert into SaleRecord (saledate,saleId) values (now(),"+ sale.getSaleID()+" );";
             Statement pstmt= con.createStatement();       
             int result=pstmt.executeUpdate(sql);
             
             
             
             for(int i=0;i<sale.getSaleLineItems().size();i++) {
            	 sql ="insert into SaleLineItem(saleId,medicineID,quantity) values ("+ sale.getSaleID() +" , "+sale.getSaleLineItems().get(i).getMedicine().getMedicinedescription().getID() +" , " +  sale.getSaleLineItems().get(i).getQuantity()  +");";
            	 pstmt= con.createStatement();       
                 result=pstmt.executeUpdate(sql);
                 
            	 
             }
          

			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
	}
   
	@Override
	public ArrayList<MedicineDescription> viewCatalog() 
	{
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {

			e1.printStackTrace();
		}
		Connection con;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sda", "root", "wotever");

			CallableStatement smt = con.prepareCall("select * from MedicineDescription");
			boolean f = smt.execute();

			ResultSet r = smt.getResultSet();
			 medicineCatalog=new ArrayList<MedicineDescription>();
			while (r.next()) {
				MedicineDescription list=new MedicineDescription(r.getString("Name"), r.getInt("medicineID"), r.getString("Description"),r.getString("type"), r.getInt("price"));
                medicineCatalog.add(list);
			}
			for(int i=0;i<medicineCatalog.size();i++)
			{
				System.out.println(medicineCatalog.get(i).getName());
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return medicineCatalog;
	   
		
	}

	@Override
	public void AddMedicine(int medicineID, int qty) {
		
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {

			e1.printStackTrace();
		}
		Connection con;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sda", "root", "wotever");
			
             String sql="UPDATE medicine m JOIN medicine n ON m.medicineid=n.medicineid SET    m.quantity = n.quantity+ "+qty+ " where m.medicineid="+medicineID +";";
             PreparedStatement pstmt=con.prepareStatement(sql);
             int row=pstmt.executeUpdate();
             	
//			for(int i=0;i<medicineCatalog.size();i++)
//			{
//				System.out.println(medicineCatalog.get(i).getName());
//			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void RemoveMedicine(int medicineID, int qty) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e1) {

					e1.printStackTrace();
				}
				Connection con;
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sda", "root", "wotever");
					
		             String sql="UPDATE medicine m JOIN medicine n ON m.medicineid=n.medicineid SET    m.quantity = n.quantity - "+qty+ " where m.medicineid="+medicineID +";";
		             PreparedStatement pstmt=con.prepareStatement(sql);
		             int row=pstmt.executeUpdate();
		             	
//					for(int i=0;i<medicineCatalog.size();i++)
//					{
//						System.out.println(medicineCatalog.get(i).getName());
//					}
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
	}

	@Override
	public void AddMedicineHistory(int managerId, int medicineID, int quantity,String type) {
		// TODO Auto-generated method stub
				try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e1) {

					e1.printStackTrace();
				}
				Connection con;
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sda", "root", "wotever");
					
		            
		             String sql;
		             sql="insert into medicinehistory (managerid,medicineid,quantity,historytype,historydate) values  ( "+ managerId +" , "+ medicineID + " , "+ quantity + " ,  '"+ type+"' , " + "NOW());";
		             
		             
		             Statement pstmt= con.createStatement();
		             
		            int result=pstmt.executeUpdate(sql);
		            

					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

	}

	@Override
	public Receipt GenerateReceipt(Sale sale) {
		Receipt receipt =new Receipt(sale);
		//receipt.setDate();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {

			e1.printStackTrace();
		}
		Connection con;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sda", "root", "wotever");
			
//            System.out.println("RECEIPT NUMBER "+ receipt.getReceiptNumber());
//            System.out.println("Sale Id  =  " + sale.getSaleID());
//            System.out.println("Total  =  " + sale.getTotal());
             String sql;
            sql="insert into receipt(receiptid,saleid,total) value(-299,-99,50);";
             // sql="insert into receipt(receiptid,saleid,total) value("+ receipt.getReceiptNumber() + " , "+ sale.getSaleID() +", " + sale.getTotal() +");";
             Statement pstmt= con.createStatement();       
             int result=pstmt.executeUpdate(sql);
             
             
          
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
		
			
		return null;
	}

	@Override
	public ArrayList<Medicine> getAllMedicines() {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {

			e1.printStackTrace();
		}
		Connection con;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sda", "root", "wotever");

			CallableStatement smt = con.prepareCall("select * from Medicine m ,MedicineDescription d where m.medicineid=d.medicineid;");
			boolean f = smt.execute();

			ResultSet r = smt.getResultSet();
		
			while (r.next()) {
				MedicineDescription list=new MedicineDescription(r.getString("Name"), r.getInt("medicineID"), r.getString("Description"),r.getString("type"), r.getInt("price"));
               Medicine list2=new Medicine();
               list2.setMedicinedescription(list);
               list2.setID(list.getID());
               AllMedicines.add(list2);
              	}
			for(int i=0;i<AllMedicines.size();i++)
			{
				System.out.println(AllMedicines.get(i).getMedicinedescription().getID());
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	   
		return AllMedicines;
	}

	@Override
	public SalesPerson getSalesPerson(String UserName, String Password)
	{
		
		// TODO Auto-generated method stub
		SalesPerson salesperson = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {

			e1.printStackTrace();
		}
		Connection con;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sda", "root", "wotever");

			CallableStatement smt = con.prepareCall("select * from salesperson where username = '"+UserName+"' and password = '"+Password+"'; ");
			boolean f = smt.execute();

			ResultSet r = smt.getResultSet();
		
		        while(r.next())
			
				{
		        	salesperson=new SalesPerson();
		        	System.out.println( r.getString("username")+ r.getString("password"));
				salesperson.setName(r.getString("username"));
				salesperson.setPassword(r.getString("password"));}
              
			con.close();
			return salesperson;
		
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	
	}

	@Override
	public Manager getManager(String UserName, String Password) {
		// TODO Auto-generated method stub
		Manager manager=null;
				try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e1) {

					e1.printStackTrace();
				}
				Connection con;
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sda", "root", "wotever");

					CallableStatement smt = con.prepareCall("select * from manager where managerusername = '"+UserName+"' and managerpassword = '"+Password+"'; ");
					boolean f = smt.execute();

					ResultSet r = smt.getResultSet();
					
				
					while(r.next())
						
						{
						manager=new Manager();
						System.out.println( r.getString("managerusername")+ r.getString("managerpassword"));
						manager.setManagername(r.getString("managerusername"));
						manager.setManagerPassword(r.getString("managerpassword"));}
		              
					con.close();
				
				}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return manager;
			
	}
   @Override
	public ArrayList<String> getSaleRecord(String from , String to) {
		// TODO Auto-generated method stub
	   ArrayList<String> rec=null;
	   
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {

			e1.printStackTrace();
		}
		Connection con;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sda", "root", "wotever");

			CallableStatement smt = con.prepareCall("select s.saleDate,s.saleID,r.receiptid,r.total from salerecord s,receipt r where s.saleDate >= '"+from+"' and s.saleDate<='"+to+"';" );
			boolean f = smt.execute();

			ResultSet r = smt.getResultSet();
			rec=new ArrayList<String> ();
			  
    		
		    
			while(r.next())
				
				{
				String str;
				     str=""+r.getDate("saledate")+"\t\t\t"+r.getInt("saleID")+"\t\t\t"+r.getInt("receiptid")+"\t\t\t"+r.getInt("total")+"";
				     rec.add(str);
				
		
		        } con.close();
		}
			catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rec;
	}

	  
		
	
	
	
}
