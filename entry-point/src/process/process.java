package process;
import java.util.ArrayList;

import entry.input.*;
import entry.xml.AutoIncrementXMLCreator;
import entry.xml.dataStaging;
import entry.input.InsertIntoHelper;
import entry.input.SelectAllFromTable;
import entry.input.SelectWhereHelper;

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
	
	
	/**
	 * Takes name of table and an arraylist of objects of that table's class as input to insert into the specified table 
	 * 
	 * @param _tableName
	 * @param _tableData
	 */
	public static void Insert(String _tableName,ArrayList<Object> _tableData){
		InsertIntoHelper.InsertionHelper(_tableName, _tableData);
	}
	
	/**
	 * Takes name of table and returns an ArrayList<Object> containing all the data of tables
	 * where each object of arraylist corresponds to a row of table.<br>
	 * <b> Cast each object of ArrayList to the object of mapped java class to be able to use it .</b>
	 * 
	 * @param _tableName
	 * @return
	 */
	public static ArrayList<Object> SelectAll(String _tableName){
		return SelectAllFromTable.ArrayListSelectAllDynamicLinker(_tableName);
	}
	
	
	/**
	 * Takes input as name of table,name of column and the value to which it should be equal to
	 * and returns and arraylist of objects
	 * 
	 * <b> Cast each and every object to the mapped class
	 * @param _tableName
	 * @param _colName
	 * @param EqualityCondition
	 * @return
	 */
	public static ArrayList<Object> SelectWhere(String _tableName,String _colName,String EqualityCondition){
		return SelectWhereHelper.SelectWhere(_tableName, _colName, EqualityCondition);
	}

}
