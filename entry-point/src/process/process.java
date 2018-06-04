package process;
import java.util.ArrayList;

import entry.input.*;
import entry.xml.AutoIncrementXMLCreator;
import entry.xml.dataStaging;

public class process {
	
	
	/**
	 * Updates the credentials.properties file (used only for creating table and autoincrement process)
	 * 
	 * @param connectionString
	 * @param tableName
	 * @param userName
	 * @param passWord
	 */
	public static void UpdateCredentials(String connectionString,String tableName,String userName,String passWord){
		
		new InputTaker(connectionString,tableName,userName,passWord);
		
		
		
	}
	
	
	/**
	 * Pass ArrayList containing objects of Class - ColumnMetaData to establish the structure of table
	 * 
	 * @param _tableStructure
	 */
	
	public static void SetTableStructure(ArrayList<ColumnMetaData> _tableStructure){
		InputTaker.columnMetaData = _tableStructure;
		
		
	}
	
	/**
	 * Call this to create the table 
	 * Order of calls to be preceeded by it are - UpdateCredentials,SetTableStructure
	 */
	public static void CreateTable(){
		dataStaging.main(null);
	}
	
	/**
	 * Sets up autoincrement property to a primary key integer column of the table specified in credentials.properties
	 * 
	 * 
	 * @param _colName
	 * @param seed
	 */
	public static void setAutoIncrement(String _colName,int seed){
		
		IncrementDataHolder idc = new IncrementDataHolder(_colName,seed);
		MasterVerificationAutoIncrement mvai = new MasterVerificationAutoIncrement();
		System.out.println("verification result : "+mvai.MasterVerifier(idc.getColumnName()));
		boolean verified = false;
		if(mvai.MasterVerifier(idc.getColumnName())){
			verified = true;
			
			@SuppressWarnings("unused")
			AutoIncrementXMLCreator aixc = new AutoIncrementXMLCreator(idc.getColumnName(),idc.getStartingSeed(),verified);
			
			
		}
	}
	
	

}
