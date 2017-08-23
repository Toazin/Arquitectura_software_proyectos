package SOLID_FinancesManager;

public class Record {
	String place;
	int amount;
	
	public Record(String place, int amount){
		this.place = place;
		this.amount = amount;
	}

	public String getPlace(){
		return this.place;
	}
	
	public int getAmount(){
		return this.amount;
	}
}
