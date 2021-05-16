package framework.core.jdbc;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Properties;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import entry.input.AutoIncrementMetaData;
import xml.processing.AutoIncrementXMLParser;

public class AutoIncrementJDBCCore {
	
	
	
	public static void CoreProcess(){
		
		try{
		Class.forName("com.mysql.jdbc.Driver");
		InputStream input  = new FileInputStream("credentials.properties");
		Properties prop = new Properties();
		prop.load(input);
		Connection con = (Connection) DriverManager.getConnection(prop.getProperty("ConnectionString").replace("\\", ""),prop.getProperty("Username"), prop.getProperty("Password"));
		
		ArrayList<AutoIncrementMetaData> getList = new ArrayList<AutoIncrementMetaData>();
		getList = AutoIncrementXMLParser.getMainArrayList();
		String tableName = prop.getProperty("Schema");
		input.close(); 
		String colName= " ";
		int seed = 1;
		String verified = "F";
		for(AutoIncrementMetaData ad : getList){
			
			colName = ad.getColName();
			seed = ad.getSeed();
			verified = ad.getVerified();
		}
		if(verified.equalsIgnoreCase("Y")){
		String sql = " ";
		String sql2 = " ";
		if(seed == 1){
			
			sql = "Alter table "+tableName+" modify "+colName+" INT auto_increment";
			Statement st = (Statement) con.createStatement();
			st.executeUpdate(sql);
			
			
		}
		
		else
		{
			
			sql = "Alter table "+tableName+" modify "+colName+" INT auto_increment";
			sql2 =  "Alter table "+tableName+" AUTO_INCREMENT ="+Integer.toString(seed);
			Statement st = (Statement) con.createStatement();
			Statement st2 = (Statement) con.createStatement();
			st.executeUpdate(sql);
			st2.executeUpdate(sql2);
			
			
		}
		
		
		}
		else
			System.out.println("Column is not the primary key of table");
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		
		
	}
	
	

}
