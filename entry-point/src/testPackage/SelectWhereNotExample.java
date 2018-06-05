package testPackage;

import java.util.ArrayList;

import process.process;
import tables.testProcess;

public class SelectWhereNotExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		// Create an arraylist of object type
				ArrayList<Object> res = new ArrayList<Object>();
				
				// define the name of table and column
				String _tableName = "testProcess";
				String _colName = "col_1";
				
				// provide what that column content should not be equal to, pass it as a string even if it
				// is an integer as it'd automatically understand if the contents are of integer or string type
				String _EqualityCondition = "90";
				
				// call the function to get the required list of resultant objects of mapped class
				res = process.SelectWhereNot(_tableName, _colName, _EqualityCondition);
				for(Object o : res){
					
					// CAST EACH AND EVERY OBJECT TO IT'S SPECIFIC CLASS
					testProcess tp = testProcess.class.cast(o);
					
					System.out.println(tp.getcol_1());
					System.out.println(tp.getcol_2());
					
				}

	}

}
