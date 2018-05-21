/**
 * 
 */
package xml.processing;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

/**
 * @author aayush
 *
 */
public class XMLStorageListCreator {
	
	/**
	 * @param Contains all the data required for table creation including connection
	 * string,schema name,username,password,column name,data type of column and if it is
	 * primary or not
	 *
	 * 
	 */
	
	public static ArrayList<XMLDataStorageClass> finalData = new ArrayList<XMLDataStorageClass>();
	
	public static ArrayList<XMLDataStorageClass> getFinalData() {
		return finalData;
	}
	
	public static void main(String args[]){
//		StoredArrayListCreator("what","true",true);
	}

	public static void StoredArrayListCreator(String cname,String dtype,boolean prime,String def){
		
		XMLDataStorageClass xmldsc = new XMLDataStorageClass();
		xmldsc.setColumnName(cname);
		xmldsc.setDataType(dtype);
		xmldsc.setPrime(prime);
		xmldsc.setDefaultVal(def);
		
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream("credentials.properties"));
			String connectionString = prop.getProperty("ConnectionString");
			String replaceWhat = "\\";
			String replaceTo = "";
			//connectionString.replaceAll(replaceWhat, replaceTo);
			connectionString.replace(replaceWhat, replaceTo);
			xmldsc.setConnectionString(connectionString);
			xmldsc.setSchema(prop.getProperty("Schema"));
			xmldsc.setUsername(prop.getProperty("Username"));
			xmldsc.setPassword(prop.getProperty("Password"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finalData.add(xmldsc);
		
	}
	

}
