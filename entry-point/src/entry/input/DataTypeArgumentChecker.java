package entry.input;

public class DataTypeArgumentChecker {
	
	/**
	 * 
	 * 
	 * @param DataType
	 * @return Number of arguments required for the data type
	 */
	
	public static int NumberOfArguments(String DataType){
		
		
		int args = 0;
		DataType = DataType.toLowerCase();
		switch(DataType){
		
		case "int" : args = 0; break;
		case "varchar" : args = 1; break;
		case "nvarchar" : args = 1; break;
		case "decimal" : args = 2; break;
		case "float" : args =2 ; break;
		
		
		default : args = -1; break;
			
		
		
		
		
		}
		
		return args;
		
		
		
	}
	

}
