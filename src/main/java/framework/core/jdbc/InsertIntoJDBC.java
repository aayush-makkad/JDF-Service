package framework.core.jdbc;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.DriverManager;
import java.util.Properties;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class InsertIntoJDBC {
	
	
	/**
	 * 
	 * @param _tableName
	 * @param _columnNames
	 * @param _columnValues
	 */
	public static void mainProcess(String _tableName,StringBuffer _columnNames,StringBuffer _columnValues){
		
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			Properties prop = new Properties();
			InputStream input = null;
			input = new FileInputStream("database-mapping-engine.properties");
			prop.load(input);
			String connectionString = prop.getProperty("ConnectionString");
			String replaceWhat = "\\";
			String replaceTo = "";
			//connectionString.replaceAll(replaceWhat, replaceTo);
			connectionString.replace(replaceWhat, replaceTo);
			Connection con = (Connection) DriverManager.getConnection(connectionString,prop.getProperty("Username"),prop.getProperty("Password"));
			Statement st = (Statement) con.createStatement();
			input.close();
			String sql = "insert into "+_tableName+" ("+_columnNames.toString()+") values ("+_columnValues.toString()+")";
			System.out.println("Running sql statement : "+sql);
			st.execute(sql);
			System.out.println("SQL statement executed successfully!!!");
			
			
			
		}catch(Exception e ){
			e.printStackTrace();
		}
		
		
	}
	
	
	

}
