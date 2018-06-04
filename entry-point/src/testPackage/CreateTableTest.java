package testPackage;
import process.process;

import java.util.ArrayList;

import entry.input.ColumnMetaData;

public class CreateTableTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		try
		{	
			
			// Setting up Connection String,Table name,Username and Password
			
			process.UpdateCredentials("jdbc:mysql://localhost:3306/mydb","testProcess","root","root");
			
			// Setting up table structure starts here
			// col_1  ||  col_2
			// int    ||   int
			// primary|| not primary
			// Default = 5 for both
			
			
			ColumnMetaData cmd[]= new ColumnMetaData[2];
			for(int i= 0;i<2;i++){
				cmd[i] = new ColumnMetaData();
				cmd[i].setDataType("int");
				cmd[i].setDefaultvalue("5");
			}
			cmd[0].setName("col_1");
			cmd[1].setName("col_2");
			cmd[0].setIdentity(true);
			cmd[1].setIdentity(false);
			
			// Table structure ends here
			
			ArrayList<ColumnMetaData> _tableStructure = new ArrayList<ColumnMetaData>();
			_tableStructure.add(cmd[0]);
			_tableStructure.add(cmd[1]);
			
			// Setting table structure for the library internal processes
			process.SetTableStructure(_tableStructure);
			
			// Creating table 
			process.CreateTable();
			
			
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}

}
