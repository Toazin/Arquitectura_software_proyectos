package SOLID_FinancesManager;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	
	String registersQty;
	public static void main(String[] args) throws FileNotFoundException, IOException {
		PersonalFinances pf = new PersonalFinances();
		pf.start();

	}
}
