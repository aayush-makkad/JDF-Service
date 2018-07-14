package framework.core.jdbc;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.DriverManager;
import java.util.Properties;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class DropTableJDBCSupportClass {
	
	
public static boolean DropTableHelper(String _tableName){
	boolean res = false;
	
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
		String sql = "drop table "+_tableName;
		st.executeUpdate(sql);
		res = true;
				
		
	}catch(Exception e){
		e.printStackTrace();
		res = false;
	}
	return res;
	
	
}

}
