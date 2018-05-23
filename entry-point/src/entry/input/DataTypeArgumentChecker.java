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
		case "char" : args = 1; break;
		case "tinytext" : args = 0; break;
		case "text" : args = 0; break;
		case "mediumtext" : args = 0; break;
		case  "longtext" : args = 0; break;
		case "tinyint" : args = 0; break;
		case "mediumint" : args = 0; break;
		case "smallint" : args = 0; break;
		case "bigint" : args = 0; break;
		case "double" : args = 2; break;
		case "nvchar" : args = 0; break;
		case "ntext" : args = 0; break;
		case "binary" : args = 1; break;
		case "varbinary" : args = 1; break;
		case "bit" : args = 0; break;
		case "numeric" : args = 2; break;
		
		default : args = -1; break;
			
		
		
		
		
		}
		
		return args;
		
		
		
	}
	

}
