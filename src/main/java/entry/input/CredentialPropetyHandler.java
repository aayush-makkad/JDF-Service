package entry.input;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

public class CredentialPropetyHandler {
	
	static String connectionString;
	static String Schema;
	static String username;
	static String password;
	/**
	 * @param connectionString
	 * @param schema
	 * @param username
	 * @param password
	 */
	public CredentialPropetyHandler(String connectionString, String schema, String username, String password) {
		super();
		CredentialPropetyHandler.connectionString = connectionString;
		Schema = schema;
		CredentialPropetyHandler.username = username;
		CredentialPropetyHandler.password = password;
		CredentialPropertyAdder();
		//dataStaging.main(null);
	}
	
	
	public boolean CredentialPropertyAdder(){
		
		Properties prop = new Properties();
		InputStream in = getClass().getResourceAsStream("credentials.properties");
		try {
			prop.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		prop.setProperty("ConnectionString",connectionString);
		prop.setProperty("Schema", Schema);
		prop.setProperty("Username", username);
		prop.setProperty("Password", password);
		
		try{
			prop.store(new FileOutputStream("credentials.properties"), null);
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
			return true;
		
	}
	
	public static HashMap<String,String> CredentialPropertyLoader()	{
		
		Properties prop = new Properties();
	    InputStream input = null;
	    HashMap<String,String> res = new HashMap<String,String>();

	    try {

	        input = new FileInputStream("credentials.properties");

	        // load properties file
	        prop.load(input);
	        
	        res.put("username", prop.getProperty("Username").toString());
	        res.put("password", prop.getProperty("Password").toString());
	        res.put("schema", prop.getProperty("Schema").toString());
	        res.put("connectionstring", prop.getProperty("ConnectionString").toString());
	      
		
	} catch(Exception e)
	    {
		e.printStackTrace();
	    }
	
	return res;

	}
}

