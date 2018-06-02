package entry.input;

import java.awt.RenderingHints.Key;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Properties;

import tables.test_table;

public class InsertIntoHelper {
	
	public static void main(String args[]){
		
		test_table te = new test_table();
		te.settry_three(6);
		te.settry_two("hey");
	//	Object o = Object.class.cast(te);
		ArrayList<Object> ar = new ArrayList<Object>();
		ar.add(te);
		InsertionHelper("test_table",ar);
	}
	
	
	public static void InsertionHelper(String _tableName,ArrayList<Object> _object){
		
		// just for abstraction
		
		for(Object o : _object)
		InsertionHelperParser(_tableName,o);
		
		
		
		
	}
	
	
	public static void InsertionHelperParser(String _tableName, Object o){
		
		
		StringBuffer columnsSelected = new StringBuffer();
		StringBuffer ColumnValues = new StringBuffer();
		
		try
		{
			Class<?> c = Class.forName("tables."+_tableName);
			Object oc = c.newInstance();
			oc.getClass().cast(o);
			Properties prop = new Properties();
			InputStream input = null;
			input = new FileInputStream(_tableName+".properties");
			prop.load(input);
			
				ArrayList<Object> ar = new ArrayList<Object>();
				ar.addAll(prop.keySet());
				String key = null;
				int ctr = 0;
		        for(Object k:ar){
		        	{
		        		
		        		if(!k.toString().contains("pm_type"))
		        		{
		        			key = (String)k;
		        		
		        		Method m = c.getDeclaredMethod("is"+key+"_bool");
		        		boolean access = (boolean) m.invoke(o);
		        		if(access){
		        			columnsSelected.append(key+",");
		        			if(prop.get("pm_type_"+key).toString().equalsIgnoreCase("int"))
		        				{
		        					Method m1 = c.getDeclaredMethod("get"+key);
		        					ctr++;
		        					ColumnValues.append((int)m1.invoke(o)+",");
		        				}
		        			
		        			
		        				
		        			else if(prop.get("pm_type_"+key).toString().equalsIgnoreCase("String"))
		        				
		        				{
		        				Method m1 = c.getDeclaredMethod("get"+key);
		        				ctr++;
		        				ColumnValues.append("'"+m1.invoke(o).toString()+"',");
		        				}
		        				
		        		}
		        			
		        			
		        			
		        				
		        		}
		        	}
		        	
		        	
		        }
		        if(ctr!=1 || ctr!=0)
	        	{
	        		ColumnValues.setLength(ColumnValues.length()-1);
	        		columnsSelected.setLength(columnsSelected.length()-1);
	        	}
	        	System.out.println("selection :"+columnsSelected.toString());
	        	System.out.println("Values :"+ColumnValues.toString());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
			
		        
		
