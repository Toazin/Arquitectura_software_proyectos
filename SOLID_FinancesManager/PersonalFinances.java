package SOLID_FinancesManager;
import java.util.Scanner;
import java.util.Date;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class PersonalFinances {
	String registersQty;
	List<Record> registerList = new ArrayList<Record>();
	Date purchaseDate = new Date();
	
	public void start() throws FileNotFoundException, IOException{
		//Obtaining and printing from console
		Day today = new Day();
		today.getRegisterData();
		today.formatting(0);
		today.printResume();
		today.formatting(1);
		today.printResume();
		//Obtaining and printing from files
		Day today2 = new Day();
		today2.getRegisterData2();
		today2.formatting(0);
		today2.writeResume();

	}

}
