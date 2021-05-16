package framework.core.jdbc;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Properties;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class ChangeColumnNameJDBC {
	
	
	
	public static void JDBCProcess(String _tableName,String _oldName,String _newName){
		
		
		
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
			Statement st2 = (Statement) con.createStatement();
			input.close();
			String _completeDataType = null;
			String sql = "SELECT COLUMN_TYPE FROM INFORMATION_SCHEMA.COLUMNS  WHERE table_name = '"+_tableName+"' AND COLUMN_NAME = '"+_oldName+"'";
			ResultSet rs1 = st.executeQuery(sql);
			while(rs1.next()){
				_completeDataType = rs1.getString("COLUMN_TYPE");
			}
			String sql2 = "ALTER TABLE "+_tableName+" CHANGE `"+_oldName+"` `"+_newName+"` "+_completeDataType;
			System.out.println(sql2);
			st2.executeUpdate(sql2);		
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
	}
	
	

}
