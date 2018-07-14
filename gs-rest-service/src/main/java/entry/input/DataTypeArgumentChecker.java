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
	
	
	/**
	 * <i>Returns if default value for this data type will need to be in inverted commas or not</i>
	 * 
	 * @return "comma" or "no comma" in a string
	 * 
	 */
	
	public static String DefaultTextOrNumerical(String DataType){
		
		
		String requirement = "comma";
		
		// number data types
		if(DataType.startsWith("int"))
			requirement = "no comma";
		if(DataType.startsWith("decimal"))
			requirement = "no comma";
		if(DataType.startsWith("float"))
			requirement = "no comma";
		if(DataType.startsWith("tinyint"))
			requirement = "no comma";
		if(DataType.startsWith("mediumint"))
			requirement = "no comma";
		if(DataType.startsWith("smallint"))
			requirement = "no comma";
		if(DataType.startsWith("bigint"))
			requirement = "no comma";
		if(DataType.startsWith("double"))
			requirement = "no comma";
		if(DataType.startsWith("numeric"))
			requirement = "no comma";
		if(DataType.startsWith("binary"))
			requirement = "no comma";
		if(DataType.startsWith("varbinary"))
			requirement = "no comma";
		if(DataType.startsWith("bit"))
			requirement = "no comma";
		
		// text data types
		if(DataType.startsWith("varchar"))
			requirement = "comma";
		if(DataType.startsWith("nvarchar"))
			requirement = "comma";
		if(DataType.startsWith("char"))
			requirement = "comma";
		if(DataType.startsWith("tinytext"))
			requirement = "comma";
		if(DataType.startsWith("mediumtext"))
			requirement = "comma";
		if(DataType.startsWith("text"))
			requirement = "comma";
		if(DataType.startsWith("longtext"))
			requirement = "comma";
		if(DataType.startsWith("ntext"))
			requirement = "comma";
		
		
		
		
		
		return requirement;
		
		
	}
	

}
