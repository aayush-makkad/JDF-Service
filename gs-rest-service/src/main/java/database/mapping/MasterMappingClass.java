package database.mapping;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import mappedclass.engine.*;

public class MasterMappingClass {
	
	public static void main(String args[]){
		new MasterMappingClass();
	}
	
	static HashMap<String,HashMap<String,String>> mainMap = new HashMap<String,HashMap<String,String>>();
	static HashMap<String,String> ResultantMap = new HashMap<String,String>();
	String TableName = null;
	public MasterMappingClass(){
		
	new MetaDataExtractionHelper();
	mainMap = MetaDataExtractionHelper.getOuterMap();
	Iterator<Map.Entry<String, HashMap<String, String>>> parent = mainMap.entrySet().iterator();
	while (parent.hasNext()) {
	    Map.Entry<String, HashMap<String, String>> parentPair = parent.next();
	    System.out.println("Name of table :   " + parentPair.getKey() + " Hashmap of Column and data types  :  " + parentPair.getValue());
	     TableName = parentPair.getKey();
	    Iterator<Map.Entry<String, String>> child = (parentPair.getValue()).entrySet().iterator();
	    while (child.hasNext()) {
	        @SuppressWarnings("rawtypes")
			Map.Entry childPair = child.next();
	        System.out.println("Column :   " + childPair.getKey() + " Data type  :  " + childPair.getValue());
	        ResultantMap.put(childPair.getKey().toString(), MappedJavaType(childPair.getValue().toString()));

	        child.remove(); // avoids a ConcurrentModificationException
	    }
	    MappingEngine.MappingSupportMethod(TableName,ResultantMap);
	    ResultantMap.clear();
	}
	
	
	}
	
	public static void SingleTableMap(){
		
		String TableName = null;
		// MetaDataExtractionHelper metaHelper = new MetaDataExtractionHelper();
		mainMap = MetaDataExtractionHelper.getOuterMap();
		Iterator<Map.Entry<String, HashMap<String, String>>> parent = mainMap.entrySet().iterator();
		while (parent.hasNext()) {
		    Map.Entry<String, HashMap<String, String>> parentPair = parent.next();
		    System.out.println("Name of table :   " + parentPair.getKey() + " Hashmap of Column and data types  :  " + parentPair.getValue());
		     TableName = parentPair.getKey();
		    Iterator<Map.Entry<String, String>> child = (parentPair.getValue()).entrySet().iterator();
		    while (child.hasNext()) {
		        @SuppressWarnings("rawtypes")
				Map.Entry childPair = child.next();
		        System.out.println("Column :   " + childPair.getKey() + " Data type  :  " + childPair.getValue());
		        ResultantMap.put(childPair.getKey().toString(), MappedJavaType(childPair.getValue().toString()));

		        child.remove(); // avoids a ConcurrentModificationException
		    }
		    MappingEngine.MappingSupportMethod(TableName,ResultantMap);
		    ResultantMap.clear();
		}
		
		
	}
	
	
	/**
	 * 
	 * <i>Takes as input the sql data type in string format and returns it's mapped java data type as string</i>
	 * 
	 * @param string
	 * @return mapped java data type
	 */
	private static String MappedJavaType(String string) {
		// TODO Auto-generated method stub
		
		String usableType = string.toLowerCase();  //converting to lower case as is not using equalsIgnorecase
		if(usableType.startsWith("int"))				// use startsWith as sql data type contains size of data type too 
			return "int";
		if(usableType.startsWith("varchar"))
			return "String";
		
		
		return null;
	}
	
	

}
