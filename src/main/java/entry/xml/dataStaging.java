package entry.xml;
import java.util.ArrayList;
import java.util.HashMap;

import entry.input.*; 

public class dataStaging {

	static HashMap<String,String> CredentialsFromProperties = new HashMap<String,String>();
	static ArrayList<ColumnMetaData> ColumnData = new ArrayList<ColumnMetaData>();
	public static HashMap<String, String> getCredentialsFromProperties() {
		return CredentialsFromProperties;
	}
	public static ArrayList<ColumnMetaData> getColumnData() {
		return ColumnData;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		CredentialsFromProperties = CredentialPropetyHandler.CredentialPropertyLoader();
		ColumnData = InputTaker.getColumnMetaData();
		
		xmlGeneration.createXML();
		
		
	}

}
