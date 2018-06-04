package testPackage;

import java.util.ArrayList;

import tables.testProcess;
import process.process;

public class InsertIntoExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		// create object of the mapped class
		testProcess tp = new testProcess();
		
		// set values of variables(Columns)
		tp.setcol_1(90);
		tp.setcol_2(18);
		
		//create ArrayList of objects
		ArrayList<Object> tableData = new ArrayList<Object>();
		
		//Add the object to list
		tableData.add(tp);
		
		//Start the process of insertion
		process.Insert("testProcess", tableData);
		

	}

}
