package entry.input;

public class IncrementDataHolder {
	
	static private String ColumnName;
	public String getColumnName() {
		return ColumnName;
	}

	public int getStartingSeed() {
		return StartingSeed;
	}

	static private int StartingSeed = 1;
	
	public IncrementDataHolder(String name,int seed){
		
		IncrementDataHolder.ColumnName = name;
		if(seed!=1)
		IncrementDataHolder.StartingSeed = seed;
		
	}
	
	
	
	

}
