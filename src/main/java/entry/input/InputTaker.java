package entry.input;

import java.util.ArrayList;

import java.util.Scanner;

public class InputTaker extends CredentialPropetyHandler {
	
	 public InputTaker(String connectionString, String schema, String username, String password) {
		super(connectionString, schema, username, password);
		// TODO Auto-generated constructor stub
	}




	static String connectionString;
	  static String schemaName;
	  static String userName;
	  static String password;
	  static String tableName;
	public static  ArrayList<ColumnMetaData> columnMetaData = new ArrayList<ColumnMetaData>();
	
	
	
	public static void setColumnMetaData(ArrayList<ColumnMetaData> columnMetaData) {
		InputTaker.columnMetaData = columnMetaData;
	}



	public static ArrayList<ColumnMetaData> getColumnMetaData() {
		return columnMetaData;
	}



	public static void main(String args[]){
			// stores column(s) data for the specific table
		
		 
		 Scanner sc = new Scanner(System.in);
		 System.out.println("Enter connection string");
		 connectionString = sc.nextLine();
		 System.out.println("Enter schema name");
		 schemaName = sc.nextLine();
		 System.out.println("Enter username");
		 userName = sc.nextLine();
		 System.out.println("Enter password");
		 password = sc.nextLine();
		 	
		 boolean flag = true;
		 String col;
		 String colDataType;
		 String primarySetter;
		 String choice;
		 boolean primary;
		 boolean primaryFlag = false;
		 String def ="";
		 String temp;
		 StringBuffer sb = new StringBuffer();
	
		 
		 while(flag){
		
			 sb.setLength(0);
			 System.out.println("Enter Column name");
			 col = sc.nextLine();
			 System.out.println("Enter data type for "+col);
			 colDataType = sc.nextLine();
//			 if(colDataType.equalsIgnoreCase("varchar") || colDataType.equalsIgnoreCase("nvarchar")){
//				
//				 sb.append(colDataType+" ");
//				 System.out.println("Size?");
//				 colDataType = sc.nextLine();
//				 sb.append("("+colDataType+")");
//				 
//			 }
//			 else
//				
			 int argsReq = DataTypeArgumentChecker.NumberOfArguments(colDataType);
			 
			 if(argsReq==0){
				 sb.append(colDataType);
			 }
			 else if(argsReq == 1){
				 sb.append(colDataType+" ");
				 System.out.println("Size?");
				 colDataType = sc.nextLine();
				 sb.append("("+colDataType+")");
			 }
			 else if(argsReq == 2){
				 
				 sb.append(colDataType+" ");
				 System.out.println("First Argument?");
				 colDataType = sc.nextLine();
				 sb.append("("+colDataType+",");
				 System.out.println("Second Argument?");
				 colDataType = sc.nextLine();
				 sb.append(colDataType+")");
				 
			 }
			 
			 System.out.println("Is it a primary key? If a primary key already exists, it will not be set");
			 primarySetter = sc.nextLine();
			 	if(primarySetter.equalsIgnoreCase("yes") && primaryFlag!=true){
			 		
			 		primary = true;
			 		primaryFlag = true;
			 		
			 	}
			 	else{
			 		primary = false;
			 	}
			 	System.out.println("Enter if it is a NON NULL column or supply a default value or enter @ if no constraints required  ");
			 	temp = sc.nextLine();
			 	if(!temp.equals("@")){
			 		def = temp;
			 	}
			 	else
			 		def = "NOT SET";
			 	
			 	
			 // preparing list
			 	
			 	columnMetaData.add(new ColumnMetaData(col,sb.toString(),primary,def));
			 	
			 System.out.println("Enter more columns?");
			 choice = sc.nextLine();
			 if(!choice.equalsIgnoreCase("yes")){
				 flag = false;
			 }
			 
		 }
		 
		 new InputTaker(connectionString,schemaName,userName,password);
		sc.close(); 
		
		
	}

}

