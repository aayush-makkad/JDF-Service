package entry.input;

import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.ResultSetMetaData;

import framework.core.jdbc.SelectWhereJDBC;
import tables.test_table;

public class SelectWhereHelper {
	
	
	
	static int EqualityCond = 0;
	static String EqualityCondString = null;
	
	public static void main(String args[]){
		
		//Select where equals
		
		ArrayList<Object> ar = SelectWhere("test_table","first_test","1");
		
		for(Object o : ar){
			
			test_table te = test_table.class.cast(o);
			System.out.println(te.gettry_two());
			
			//System.out.println(te.getfive_test());
			
			
		}
		
		// select where not equals
		
		ArrayList<Object> ar2 = SelectWhereNot("test_table","first_test","1");
		
		for(Object o : ar2){
			
			test_table te = test_table.class.cast(o);
			System.out.println(te.gettry_two());
			
			//System.out.println(te.getfive_test());
			
			
		}
		
	}
	
	/**
	 * 
	 * 
	 * @param _tableName
	 * @param _colName
	 * @param EqualityCondition
	 * @return
	 */
	
	public static ArrayList<Object> SelectWhere(String _tableName,String _colName,String EqualityCondition){
		
		ArrayList<Object> output = null;
		
	
		
		try{
			
			
			
			int i = Integer.parseInt(EqualityCondition);
			
			// if it is actually an integer, follow this
			
			EqualityCond = i;
			output = SelectWhereJDBCCaller(_tableName,_colName,true);
			
		}
		catch(Exception e){
			
			//if it is not an integer but a string, follow this
			
			EqualityCondString = EqualityCondition;
			output = SelectWhereJDBCCaller(_tableName,_colName,false);
			
		}
		
		return output;
		
	}
	
	
	
	public static ArrayList<Object> SelectWhereNot(String _tableName,String _colName,String EqualityCondition){
		
		String newName = "NOT "+_colName;
		ArrayList<Object> output = SelectWhere(_tableName,newName,EqualityCondition);
		return output;
				
		
	}
	
	
	public static ArrayList<Object> SelectWhereJDBCCaller(String _tableName,String _colName,boolean isInt){
		
		ArrayList<Object> res = null;
		
		if(isInt)
		{
			
			ResultSet rs =SelectWhereJDBC.MainProcessINT(_tableName,_colName,EqualityCond);
			 res = ArrayListWrapperCreator(rs);
		}
		else
		{
			ResultSet rs = SelectWhereJDBC.MainProcessString(_tableName, _colName, EqualityCondString);
			 res = ArrayListWrapperCreator(rs);
		}
		
		return res ;
		
	}
	
	
public static ArrayList<Object> ArrayListWrapperCreator(ResultSet _resultset){
		
		ArrayList<Object> resultant = new ArrayList<Object>();
		
		try{
			
		
		ResultSetMetaData rsmd = (ResultSetMetaData) _resultset.getMetaData();
		String tableName = rsmd.getTableName(1);
		int _columnCount = rsmd.getColumnCount();

		
		ArrayList<String> ar = new ArrayList<String>();
		for(int i = 1;i<_columnCount+1;i++)
		{
			ar.add(rsmd.getColumnName(i));
		}
		
		Class<?> DesiredClass = null;
		StringBuffer sb = new StringBuffer();
		
		try{
		 DesiredClass = Class.forName("tables."+tableName);
		 System.out.println("class loaded "+DesiredClass.toString());
		// System.out.println("\n/n\n/n");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		while(_resultset.next()){
			
			// System.out.println("In loop of rs");
			Object o = DesiredClass.newInstance();
			int j= 0;
			for(String s : ar){
				
				j++;
				
				String sqltype = rsmd.getColumnTypeName(j);
				sb.setLength(0);
				
				if(sqltype.startsWith("INT"))
					sb.append("In");
				else
					sb.append("String");
				
				
				
				if(sb.length()<4)
				{
					Method m = DesiredClass.getDeclaredMethod("set"+s,int.class);
					m.invoke(o,_resultset.getInt(s));
					
				}
				 if(sb.length()>4)
				{
					Method m = DesiredClass.getDeclaredMethod("set"+s,String.class);
					m.invoke(o, _resultset.getString(s));
					
				}
				
				
			}
			resultant.add(o);
			
			
		}
		
		
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return resultant;
	}
	


	
	
	

}
