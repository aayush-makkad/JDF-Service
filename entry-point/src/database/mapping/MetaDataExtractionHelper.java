package database.mapping;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSetMetaData;
import com.mysql.jdbc.Statement;

public class MetaDataExtractionHelper {
	
	static ArrayList<String> tableNames = new ArrayList<String>();
	static HashMap<String,HashMap<String,String>> outerMap = new HashMap<String,HashMap<String,String>>();
	static HashMap<String,String> innerMap = new HashMap<String,String>();

	public static void main(String args[]){
		tableNames = extraction();
		System.out.println("Columns starts here");
		for(String s : tableNames){
			
			outerMap.put(s,TableData(s));
			
		}
		
	}
	
	
	
	public static ArrayList<String> extraction(){
		
	ArrayList<String> _tables = new ArrayList<String>();
	Properties prop = new Properties();
	InputStream input = null;
	try{
		input = new FileInputStream("database-mapping-engine.properties");
		prop.load(input);
		Class.forName("com.mysql.jdbc.Driver");
		String connectionString = prop.getProperty("ConnectionString");
		String replaceWhat = "\\";
		String replaceTo = "";
		connectionString.replace(replaceWhat, replaceTo);
		Connection con = (Connection) DriverManager.getConnection(connectionString,prop.getProperty("Username"),prop.getProperty("Password"));
		String DbName = prop.getProperty("Database");
		input.close();
		Statement st = (Statement) con.createStatement();
		String sql = "select table_name from information_schema.tables where table_schema in ('"+DbName+"')";
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()){
		//	System.out.println(rs.getString("table_name"));
			_tables.add(rs.getString("table_name"));
		}
		
		for(String s : _tables){
			System.out.println(s);
		}
		
		
	
	}
	catch(Exception e){
		e.printStackTrace();
	}
	
	return _tables;
	}
	
	
	public static HashMap<String,String> TableData(String _tableName){
		
		HashMap<String,String> res = new HashMap<String,String>();
		try{
			InputStream input = null;
			Properties prop = new Properties();
			input = new FileInputStream("database-mapping-engine.properties");
			prop.load(input);
			Class.forName("com.mysql.jdbc.Driver");
			String connectionString = prop.getProperty("ConnectionString");
			String replaceWhat = "\\";
			String replaceTo = "";
			connectionString.replace(replaceWhat, replaceTo);
			Connection con = (Connection) DriverManager.getConnection(connectionString,prop.getProperty("Username"),prop.getProperty("Password"));
			Statement st = (Statement) con.createStatement();
			String sql = "select * from "+_tableName;
			ResultSet rs = st.executeQuery(sql);
			ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			for(int i=1;i<columnCount-1;i++){
				res.put(rsmd.getColumnName(i), rsmd.getColumnTypeName(i));
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return res;
		
	}
	
	
	
	
}
