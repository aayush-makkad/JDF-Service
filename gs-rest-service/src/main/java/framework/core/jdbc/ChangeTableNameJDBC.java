package framework.core.jdbc;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.DriverManager;

import java.util.Properties;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class ChangeTableNameJDBC {
	
	
	public static void JDBCProcess(String _oldTableName,String _newTableName){
		
		
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
			
			Statement st2 = (Statement) con.createStatement();
			input.close();
			
			String sql2 = "rename table `"+_oldTableName+"` to `"+_newTableName+"`";
			System.out.println(sql2);
			st2.executeUpdate(sql2);		
			
			
			
		}catch(Exception e ){
			e.printStackTrace();
		}
		
		
		
	}
	

}
