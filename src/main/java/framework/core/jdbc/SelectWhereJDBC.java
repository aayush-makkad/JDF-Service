package framework.core.jdbc;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Properties;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class SelectWhereJDBC {
	
	
	
public static ResultSet MainProcessINT(String _tableName,String _colname,int eq){
	
		ResultSet rs = null;
		
		
			try{
				String sql = null;
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
				
				 sql = "select * from "+_tableName+" where "+_colname+" = "+eq;
				
					
				 rs = st.executeQuery(sql);
				


			}catch(Exception e){
				e.printStackTrace();
				
			}
		
		return rs;
		
	}
	

public static ResultSet MainProcessString(String _tableName,String _colname,String eq){
	
	ResultSet rs = null;
	
	
		try{
			String sql = null;
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
			
			 sql = "select * from "+_tableName+" where "+_colname+" = '"+eq+"'";
			
				
			 rs = st.executeQuery(sql);
			


		}catch(Exception e){
			e.printStackTrace();
			
		}
	
	return rs;
	
}


}
