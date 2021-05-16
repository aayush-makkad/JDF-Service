/**
 * 
 */
package sanitycheck.autoIncrement;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;



/**
 * @author aayush
 *
 */
public class XMLCredentialPropertiesSchema {
	
	static String tableNameXML = null;
	static String tableNameProperties = null;
	
	public static boolean SanityCheckRun(){
		tableNameXML=TableNameFromXML();
		tableNameProperties = TableNameFromProperties();
	
		
		return SanityCheck();
		
		
	}
	
	
	 static String TableNameFromXML(){
		 	
		 	String result = null;
		
		try{
			
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			
			String filePath = "process-auto-increment.xml";
	        File xmlFile = new File(filePath);
	        Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nodeList = doc.getElementsByTagName("Schema");
          // Main ArrayList
            
				 result = getMetaData(nodeList.item(0));
			
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		if(!result.equalsIgnoreCase(null))
		return result;
		else
			return "Oops from XML"; 
		
		
	}
	 
	 
	 static String TableNameFromProperties(){
		 
		 String result = null;
		 
		 try{
			 InputStream input = new FileInputStream("credentials.properties");
			 Properties prop = new Properties();
			 prop.load(input);
			 result = prop.getProperty("Schema");
			 System.out.println("Table nme from properties : "+result);
			 input.close();
			 
			 
		 }
		 catch(Exception e){
			 e.printStackTrace();
		 }
		 
		 if(!result.equalsIgnoreCase(null))
			 return result;
		 else
			 return "Oops!";   // Yes oops, since you messed up
		 
	 }
	 
	 
	 private static String getMetaData(Node node) {
			// TODO Auto-generated method stub
			Element element1 = (Element) node;
			String tableName = element1.getAttribute("Name");
			System.out.println("Table Name extracted from XML by sanity check : "+tableName);
			return tableName;
			
			
		}
	 
	 public static boolean SanityCheck(){
		 
		 if(tableNameXML.equalsIgnoreCase(tableNameProperties)){
			 return true;
		 }
		 else
			 return false;
		 
		 
	 }
		
	
	

}
