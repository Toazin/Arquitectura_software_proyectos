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
		Day today = new Day();
		today.getRegisterData2();
		today.formatting(1);
		today.printResume();
		today.writeResume();
//		today.getRegisterData2();
	}

}
