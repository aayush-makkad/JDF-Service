package entry.input;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MappingPropertyHandler {

	
	public static String ConnectionString;
	public static String DataBaseName;
	public static String userName;
	public static String password;
	
	public MappingPropertyHandler(String connectionString, String schema, String username, String password) {
		super();
		MappingPropertyHandler.ConnectionString = connectionString;
		MappingPropertyHandler.DataBaseName = schema;
		MappingPropertyHandler.userName = username;
		MappingPropertyHandler.password = password;
		CredentialPropertyAdder();
		//dataStaging.main(null);
	}
	
	
	public boolean CredentialPropertyAdder(){
		
		Properties prop = new Properties();
		InputStream in = getClass().getResourceAsStream("database-mapping-engine.properties");
		try {
			prop.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		prop.setProperty("ConnectionString",ConnectionString);
		prop.setProperty("Database", DataBaseName);
		prop.setProperty("Username", userName);
		prop.setProperty("Password", password);
		
		try{
			prop.store(new FileOutputStream("database-mapping-engine.properties"), null);
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
			return true;
		
	}
	
	
	
}
