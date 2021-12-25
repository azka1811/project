package application;
import java.io.IOException;
import java.util.ArrayList;  
import javafx.application.Application;
import javafx.stage.Stage;
import sun.util.calendar.BaseCalendar.Date;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {		
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Sample.fxml"));
			Scene scene = new Scene(root,600,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("yes");
			primaryStage.setScene(scene);
			primaryStage.show();
			System.out.println("yes");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
//		Pharmacy pharmacy=new Pharmacy();
//	pharmacy.StartSale();
//	pharmacy.EnterProduct(1, 999);
//	float x=pharmacy.EnterProduct(2, 222);
//		
//	pharmacy.StartPayment("CashPayment");
//	float y=pharmacy.MakePayment(x, 5000);
//	pharmacy.closeSale();
//	System.out.println(" \r\n product "+x+" "+y);
		//MedicineCatalog catalog=pharmacy.getMedicineCatalog();
	     //catalog.DisplayCatalog();
		Thread SampleController = new Thread("Login1");
        Thread SampleController2 = new Thread("Login2");
        SampleController.start();
        SampleController2.start();
        System.out.println("Threads have started\n");
	    // DBHandler ob=new MySQL();
	    // ob.getManager("Wasay1", "1234");
	     //System.out.println(pharmacy.ManagerLogin("Wasay1","1234"));
	     //ob.getSalesPerson("off", "aunoff");
	     
	     
	    //ob.getSaleRecord("2020-12-25","2020-12-25");
	     launch(args);
	}
}
