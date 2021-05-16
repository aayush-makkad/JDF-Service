package testPackage;


import process.process;

import java.util.ArrayList;

import entry.input.*;

public class beanHandlerToRest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		ColumnMetaData cmd = new ColumnMetaData();
		cmd.setName("col_11");
		cmd.setDataType("int");
		cmd.setDefaultvalue("2");
		cmd.setIdentity(false);
		ArrayList<ColumnMetaData> ar = new ArrayList<ColumnMetaData>();
		ar.add(cmd);
		process.SetTableStructure(ar);
		process.CreateTable();
		
		
		
	}

}
