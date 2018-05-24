package mappedclass.engine;

import java.util.HashMap;
import java.util.Map.Entry;

import framework.core.jdbc.*;

public class MappingEngine {
	
	public MappingEngine(){
	HashMap<String,String> colData = jdbcCore.getJavaMappedColumns();
	
//	for (Entry<String, String> entry : colData.entrySet()) {
//	    System.out.println(entry.getKey());
//	     System.out.println(entry.getValue());
//	    
//	}
	
	}
	
	

}
