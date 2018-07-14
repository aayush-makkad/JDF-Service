package testPackage;

import tables.testProcess;
import tables.test_table;

import java.util.ArrayList;

import process.process;

public class SelectAllExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//create an arraylist to hold the returned obects
		ArrayList<Object> _tableData = new ArrayList<Object>();
		
		//get the returned objects
		_tableData = process.SelectAll("test_table");
		
		
		for(Object o : _tableData){
			
			// CAST EACH AND EVERY OBJECT TO IT'S MAPPED CLASS
			test_table tp = test_table.class.cast(o);
			
			// Use getters to get the values
			//System.out.println("col_1 data : "+tp.getfirst_test());
			//System.out.println("col_2 data : "+tp.getfive_test());
			System.out.println("col_2 data : "+tp.getsix_test());
		}
		
		

	}

}
