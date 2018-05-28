package entry.input;
import java.util.Scanner;

import database.mapping.MetaDataExtractionHelper;
import framework.core.jdbc.*;

public class ColumnNameChangeInputProcessor {
	
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the name of table");
		String _tableName = sc.nextLine();
		System.out.println("Enter the name of column");
		String _oldName = sc.nextLine();
		System.out.println("Enter new name for the column "+_oldName);
		String _newName = sc.nextLine();
		Processor(_tableName,_oldName,_newName);
		sc.close();
		
	}
	
	/**
	 * 
	 * 
	 * @param _tableName
	 * @param _oldName
	 * @param _newName
	 */
	public static void Processor(String _tableName,String _oldName,String _newName) {
		
		System.out.println("Changing column name from database");
		ChangeNameColumnJDBC(_tableName,_oldName,_newName);
		System.out.println("Column Name changed in database");
		System.out.println("Creating mappings for altered table");
		DropTableInputHelper.BindingDeletion(_tableName);
	    MetaDataExtractionHelper.SingleTableMappingReconstrunction(_tableName);
	    System.out.println("Created mappings for altered table");
		
		
	}
	
	
	public static void ChangeNameColumnJDBC(String _tableName,String _oldName,String _newName){
		
		
		ChangeColumnNameJDBC.JDBCProcess(_tableName, _oldName, _newName);
		
		
		
		
	}
	

}
