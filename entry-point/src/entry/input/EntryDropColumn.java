package entry.input;
import framework.core.jdbc.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.Scanner;

public class EntryDropColumn {
	
	
	public static void main(String args[]){
		
		String a,b;
		System.out.println("Enter table name");
		Scanner sc = new Scanner(System.in);
		a = sc.nextLine();
		System.out.println("Enter column name");
		b = sc.nextLine();
		DropColumn(a,b);
		sc.close();
		
	}
	
	
	public static void DropColumn(String _tableName,String _colName){
		
		boolean res = jdbcDropColumnProcessHelper(_tableName,_colName);
		if(res){
			System.out.println("Column "+_colName+" dropped from database succcessully");
			System.out.println("Deleting binding entry now");
			PropertyBindingDeletionHandler(_tableName,_colName);
			System.out.println("Deleted Binding Entry");
			
		}
		else
			System.out.println("Couldn't drop the column");
		
		
		
	}
	
	public static void PropertyBindingDeletionHandler(String _tableName,String _colName){
		
		Properties prop = new Properties();
		InputStream input = null;
		OutputStream os = null;
		try{
		input = new FileInputStream(_tableName+".properties");
		prop.load(input);
		prop.remove(_colName);
		os = new FileOutputStream(_tableName+".properties");
		prop.store(os, "Bindings for "+_tableName);
		input.close();
		os.close();
		
		//input.close();
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
	
	public static boolean jdbcDropColumnProcessHelper(String _tableName,String _colName){
		
		boolean res = false;
		System.out.println("Dropping Column "+_colName+" from database");
		res = DropColumnProcess.ColumnDropJDBC(_tableName,_colName);
		
		return res;
		
	}

}
