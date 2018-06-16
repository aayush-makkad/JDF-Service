package logical.operations;

import java.util.ArrayList;

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
	
	public static void SelectIn(String _colName,ArrayList<Integer> _lsInt){
		StringBuilder sb = new StringBuilder();
		 sb.append(_lsInt.toString());
		 sb.replace(0, 1, "(");
		 sb.replace(sb.length()-1, sb.length(), ")");
		 System.out.println(sb.toString());
		 SQLStringHolder.setMainString("where "+_colName+" in "+sb.toString());
		 
	}

}
