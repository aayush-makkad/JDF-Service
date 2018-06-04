package testPackage;

import tables.testProcess;

import java.util.ArrayList;

import process.process;

public class SelectAllExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//create an arraylist to hold the returned obects
		ArrayList<Object> _tableData = new ArrayList<Object>();
		
		//get the returned objects
		_tableData = process.SelectAll("testProcess");
		
		
		for(Object o : _tableData){
			
			// CAST EACH AND EVERY OBJECT TO IT'S MAPPED CLASS
			testProcess tp = testProcess.class.cast(o);
			
			// Use getters to get the values
			System.out.println("col_1 data : "+tp.getcol_1());
			System.out.println("col_2 data : "+tp.getcol_2());
		}
		
		

	}

}
