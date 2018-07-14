package logical.operations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SQLStringBuildProcessor {
	
	
	
	
	

	public static void SelectFromBuild(String tableName, String col){
		
		
		SQLStringHolder.setMainString("Select "+col+" from "+tableName);
		
		
	}
	
	public static void SelectWhereBuild(String colName,String EqualityCondition){
		
		int i=0;
		
		try{
			i = Integer.parseInt(EqualityCondition);
			SQLStringHolder.setMainString("Where "+colName+" = "+i);
		}catch(Exception e){
			SQLStringHolder.setMainString("Where "+colName+" = '"+EqualityCondition+"'");
		}
	}
	
	public static void SelectANDBuild(String colName,String EqualityCondition){
		int i=0;
		
		try{
			i = Integer.parseInt(EqualityCondition);
			SQLStringHolder.setMainString("and "+colName+" = "+i);
		}catch(Exception e){
			SQLStringHolder.setMainString("and "+colName+" = '"+EqualityCondition+"'");
		}
	}
	
	public static void SelectNOT(){
		SQLStringHolder.setMainString("not");
	}
	
	public static void SelectLike(String colName,String Condition){
		SQLStringHolder.setMainString("where "+colName+" like  "+Condition);
	}
	
	public static void SelectIn(String _colName,ArrayList<Object> _lsInt){
		StringBuilder sb = new StringBuilder();
		ArrayList<Object> _res = new ArrayList<Object>();
		_res = ListCleaningProcess(_lsInt);
		 sb.append(_res.toString());
		 sb.replace(0, 1, "(");
		 sb.replace(sb.length()-1, sb.length(), ")");
		 System.out.println(sb.toString());
		 SQLStringHolder.setMainString("where "+_colName+" in "+sb.toString());
		 
	}
	
	private static ArrayList<Object> ListCleaningProcess(ArrayList<Object> _process)
	{
		
		StringBuilder sb = new StringBuilder();
		sb.append(_process.toString().charAt(0));
		HashMap<Integer,String> _memory = new HashMap<Integer,String>();
 		for(Object o : _process){
			
			 if(o instanceof String){
				
				int index = _process.indexOf(o);
				String s = String.class.cast(o);
				String put = "'"+s+"'";
				_memory.put(_process.indexOf(o),put);
				
			}
			
		}
 		Iterator<Map.Entry<Integer,String>> itr = _memory.entrySet().iterator();
		while(itr.hasNext()){
			Map.Entry<Integer, String> ent = itr.next();
				
			
			_process.set(ent.getKey(), ent.getValue());
		}
		return _process;
	}

}
