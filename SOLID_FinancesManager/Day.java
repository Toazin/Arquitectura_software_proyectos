package SOLID_FinancesManager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Day{
	private Date purchaseDate;
	private String currency;
	private String frecuent;
	private String[] currencyArray;
	private String[] dateFormatArray;
	private int recordsQuantity;
	private int max;
	private int min;
	private int total;
	private float average;
	private Map<String,Integer> recordHash;
	private List<Record> dayRecords;
	private SimpleDateFormat sf;	
	
	public Day(){
		this.currency = "$";
		this.frecuent = "";
		this.currencyArray = new String[]{"$","Y"};
		this.dateFormatArray = new String[]{"DD/MM/YY","MM-DD-YYYY"};
		this.dayRecords = new ArrayList<Record>();
		this.recordsQuantity = 0;
		this.max = -1;
		this.min = -1;
		this.total = 0;
		this.average = -1;
		this.recordHash = new HashMap<String,Integer>();
		
		this.purchaseDate = new Date();
	}
	
	public void getRegisterData(){
		Scanner sc = new Scanner(System.in);
		System.out.println("¿Cuantas compras realizo hoy?");
		int qty = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < qty; i++) {
			String reg = sc.nextLine();
			addToList(reg);
		}
	}
	
	public void getRegisterData2() throws FileNotFoundException, IOException{
		String filePath = new File("").getAbsolutePath().concat("\\src\\SOLID_FinancesManager\\data.txt");
		try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();
		    while (line != null) {
		    	addToList(line);
		        line = br.readLine();
		    }
		}
	}
	
	public void addToList(String s){
		
		String[] splited = s.split(" ");
		String place = splited[0];
		int amount = Integer.parseInt(splited[1]);
		this.recordsQuantity++;
		this.total += amount;
		Record r = new Record(place,amount);
		this.dayRecords.add(r);
		compareMin(r);
		compareMax(r);
		getNewAverage(r);
		obtainFrequent(r);
	}
	
	public void compareMin(Record r){
		if(this.min == -1){
			this.min = r.amount;
		}else{
			if(r.amount < this.min) this.min = r.amount;
		}
	}
	
	public void compareMax(Record r){
		if(this.max == -1){
			this.max = r.amount;
		}else{
			if(r.amount > this.max) this.max = r.amount;
		}
	}
	
	public void getNewAverage(Record r){
		if(this.average == -1){
			this.average = r.amount;
		}else{
			this.average = this.total / this.recordsQuantity;
		}
	}
	
	public void obtainFrequent(Record r){
		this.recordHash.put(r.getPlace(), this.recordHash.getOrDefault(r.getPlace(),0) + 1);
		
		String maxPlace = "";
		int max = 0;
		for (Map.Entry<String, Integer> entry : this.recordHash.entrySet())
		{
			if(entry.getValue()> max){
				maxPlace = entry.getKey();
				max = entry.getValue();
			}
		}
		this.frecuent = maxPlace;
	}
	
	public void formatting(int n){
		this.currency = this.currencyArray[n];
		this.sf = new SimpleDateFormat(this.dateFormatArray[n]);
	}
	
	public void printResume(){
		System.out.println("Purchases of " + this.sf.format(this.purchaseDate));
		System.out.println("");
		System.out.println("Min: " + this.currency + this.min);
		System.out.println("Max: " + this.currency + this.max);
		System.out.println("Average: " + this.currency + this.average);
		System.out.println("");
		System.out.println("Frequent Payee: " + this.frecuent);
	}
	
	public void writeResume(){
		String filePath = new File("").getAbsolutePath().concat("\\src\\SOLID_FinancesManager\\resume.txt");
		BufferedWriter bw = null;
		FileWriter fw = null;

		try {
			String content = "Purchases of " + this.sf.format(this.purchaseDate) + "\n" +
							""  + "\n" +
							"Min: " + this.currency + this.min  + "\n" +
							"Max: " + this.currency + this.max  + "\n" +
							"Average: " + this.currency + this.average  + "\n" +
							""  + "\n" +
							"Frequent Payee: " + this.frecuent;
			fw = new FileWriter(filePath);
			bw = new BufferedWriter(fw);
			bw.write(content);
			System.out.println("Done");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
				if (fw != null)
					fw.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
	}
	
//	public void obtainMin(){
//		int min = 9999;
//		for (final Record record : this.dayRecords) {
//	        if(record.getAmount() < min) min = record.getAmount();
//		}
//		System.out.println("Min: " + min);
//	}
//	
//	public void obtainMax(){
//		int max = 0;
//		for (final Record record : this.dayRecords) {
//	        if(record.getAmount() > max) max = record.getAmount();
//		}
//		System.out.println("MAX: " + max);
//	}
//	
//	public void obtainAverage(){
//		int sum = 0;
//		for (final Record record : this.dayRecords) {
//			sum = sum + record.getAmount();
//		}
//		float average = sum/Integer.parseInt(this.recordsQuantity);
//		System.out.println("AVERAGE: " + average);
//	}
//
//	public void obtainFrequent(){
//	Map<String,Integer> hash=new HashMap<String,Integer>();
//	for (Record record : this.registerList) {
//		hash.put(record.getPlace(), hash.getOrDefault(record.getPlace(),0) + 1);
//	}
//	
//	String maxPlace = "";
//	int max = 0;
//	for (Map.Entry<String, Integer> entry : hash.entrySet())
//	{
//		if(entry.getValue()> max){
//			maxPlace = entry.getKey();
//			max = entry.getValue();
//		}
//	}
//	System.out.println("Frequent Payee: " + maxPlace);
//}
	
}
