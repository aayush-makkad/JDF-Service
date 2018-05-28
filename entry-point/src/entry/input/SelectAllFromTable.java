package entry.input;
import tables.*;

import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;

import com.mysql.jdbc.ResultSetMetaData;

import framework.core.jdbc.SelectAllJDBC;

public class SelectAllFromTable {
	
	static ArrayList<Object> ar = new ArrayList<Object>();
	public static void ArrayListSelectAllDynamicLinker(String _tableName){
		
		
		ar = JDBCProcessCaller(_tableName);
		
		
	}
	public static void main(String args[]){
		
		ArrayListSelectAllDynamicLinker("test_table");
		for(Object o : ar){
			System.out.println(o.getClass().getName());
			
			
		}
		
	}
	
//	public static ArrayList<Object> RunSelectAll(String _tableName){
//		
//		
//		JDBCProcessCaller(_tableName);
//		
//		
//		
//		
//	}
	
	
	public static ArrayList<Object> JDBCProcessCaller(String _tableName){
		
		
		ResultSet rs = SelectAllJDBC.MainProcess(_tableName);
		ArrayList<Object> wrappedlist = new ArrayList<Object>();
		wrappedlist = ArrayListWrapperCreator(rs);
		
		return wrappedlist;
		
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
		
		Class DesiredClass = null;
		StringBuffer sb = new StringBuffer();
		
		try{
		 DesiredClass = Class.forName("tables."+tableName);
		 System.out.println("class loaded "+DesiredClass.toString());
		 System.out.println("\n/n\n/n");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		while(_resultset.next()){
			
			System.out.println("In loop of rs");
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
