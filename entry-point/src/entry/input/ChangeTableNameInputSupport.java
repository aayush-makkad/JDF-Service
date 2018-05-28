package entry.input;

import java.util.Scanner;

import database.mapping.MetaDataExtractionHelper;
import framework.core.jdbc.ChangeTableNameJDBC;

public class ChangeTableNameInputSupport {
	
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the name of table");
		String _tableName = sc.nextLine();
		System.out.println("Enter the new name of table");
		String _oldName = sc.nextLine();
		ChangeTableName(_tableName,_oldName);
		sc.close();
	}
	
	
	public static void ChangeTableName(String _oldTableName,String _newTableName){
		
		try{
		System.out.println("Changing table name in database");
		ChangeTableNameJDBCSupport(_oldTableName,_newTableName);
		System.out.println("Table name changed in database");
		System.out.println("Creating mappings for altered table");
		DropTableInputHelper.BindingDeletion(_oldTableName);
		DropTableInputHelper.BindingDeletion(_newTableName);
	    MetaDataExtractionHelper.SingleTableMappingReconstrunction(_newTableName);
	    System.out.println("Created mappings for altered table");
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
	}
	
	
	public static void ChangeTableNameJDBCSupport(String _oldTableName,String _newTableName){
		
		
		ChangeTableNameJDBC.JDBCProcess(_oldTableName, _newTableName);
	}
	
	

}
