package TD_List;

public class TDDList implements IList{
	private int count = 0;
	
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return count;
	}

	@Override
	public void add(String element) {
		count++;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		count = 0;
	}

	@Override
	public boolean remove(Integer index) {
		// TODO Auto-generated method stub
		assert index >=0;
		if(count-1 < index){
			return false;
		}else{
			count--;
		}
		return true;
	}

	@Override
	public String get(Integer index) {
		// TODO Auto-generated method stub
		
		return count + "";
	}

}
