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
	static  ArrayList<ColumnMetaData> columnMetaData = new ArrayList<ColumnMetaData>();
	
	
	
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
		 while(flag){
			 
			 System.out.println("Enter Column name");
			 col = sc.nextLine();
			 System.out.println("Enter data type for "+col);
			 colDataType = sc.nextLine();
			 System.out.println("Is it a primary key?");
			 primarySetter = sc.nextLine();
			 	if(primarySetter.equalsIgnoreCase("yes")){
			 		
			 		primary = true;
			 		
			 	}
			 	else{
			 		primary = false;
			 	}
			 // preparing list
			 	
			 	columnMetaData.add(new ColumnMetaData(col,colDataType,primary));
			 	
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

