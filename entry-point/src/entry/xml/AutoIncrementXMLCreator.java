package entry.xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import entry.input.CredentialPropetyHandler;

public class AutoIncrementXMLCreator {
	
	static HashMap<String,String> param;
	
	
	public AutoIncrementXMLCreator(String colname,int seed,boolean verified){
		
		
	 param = CredentialPropetyHandler.CredentialPropertyLoader();
		
		
		try{
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();
			
			//create here
			
			Element rootElement = doc.createElement("Create-Table");
	        doc.appendChild(rootElement);
	        
	        Element connect = doc.createElement("Connection-String");
	        rootElement.appendChild(connect);
	        
	        Attr attr = doc.createAttribute("String");
	        attr.setValue(param.get("connectionstring"));
	        connect.setAttributeNode(attr);
	        
	        Element schema = doc.createElement("Schema");
	        rootElement.appendChild(schema);
	        
	        Attr attr2 = doc.createAttribute("Name");
	        attr2.setValue(param.get("schema"));
	        schema.setAttributeNode(attr2);
	        
	        
	        Element user = doc.createElement("username");
	        rootElement.appendChild(user);
	        
	        Attr attr3 = doc.createAttribute("Name");
	        attr3.setValue(param.get("username"));
	        user.setAttributeNode(attr3);
	        
	        Element pass = doc.createElement("Password");
	        rootElement.appendChild(pass);
	        
	        Attr attr4 = doc.createAttribute("Name");
	        attr4.setValue(param.get("password"));
	        pass.setAttributeNode(attr4);
	        
	        // global param ends here
	        
	        
	        Element column = doc.createElement("Column");
	        rootElement.appendChild(column);
	        
	        Element name = doc.createElement("Column-Name");
	        //Attr attrType = doc.createAttribute("Name");
	        //attrType.setValue(ColName);
	        //name.setAttributeNode(attrType);
	        name.appendChild(doc.createTextNode(colname));
	        column.appendChild(name);
	        
	        String verification;
	        if(verified == true){
	        	
	        	verification = "Y";
	        	
	        	
	        }
	        else 
        		verification = "N";
	        
	        Element type = doc.createElement("Verified");
	        //Attr attrType = doc.createAttribute("Name");
	        //attrType.setValue(ColName);
	        //name.setAttributeNode(attrType);
	        type.appendChild(doc.createTextNode(verification));
	        column.appendChild(type);
	        
	        Element primary = doc.createElement("Start-From");
	        //Attr attrType = doc.createAttribute("Name");
	        //attrType.setValue(ColName);
	        //name.setAttributeNode(attrType);
	        primary.appendChild(doc.createTextNode(Integer.toString(seed)));
	        
	        column.appendChild(primary);
	        
	        TransformerFactory transformerFactory = TransformerFactory.newInstance();
	        Transformer transformer = transformerFactory.newTransformer();
	        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	        transformer.setOutputProperty(OutputKeys.METHOD, "xml");
	        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
	        DOMSource source = new DOMSource(doc);
	        StreamResult result = new StreamResult(new File("process-auto-increment.xml"));
	        transformer.transform(source, result);
	        
	        StreamResult consoleResult = new StreamResult(System.out);
	        transformer.transform(source, consoleResult);
	        
		
		
		
	}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * 
	 * 
	 * @param colname
	 * @param seed
	 * @param verified
	 * @param tablename
	 * @param use this function when Table Name entered exists, else will generate error
	 */
	
	public AutoIncrementXMLCreator(String colname,int seed,boolean verified,String tablename)
	{
		
			
			
			 param = CredentialPropetyHandler.CredentialPropertyLoader();
				
				
				try{
					DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
					DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
					Document doc = dBuilder.newDocument();
					
					//create here
					
					Element rootElement = doc.createElement("Create-Table");
			        doc.appendChild(rootElement);
			        
			        Element connect = doc.createElement("Connection-String");
			        rootElement.appendChild(connect);
			        
			        Attr attr = doc.createAttribute("String");
			        attr.setValue(param.get("connectionstring"));
			        connect.setAttributeNode(attr);
			        
			        Element schema = doc.createElement("Schema");
			        rootElement.appendChild(schema);
			        
			        Attr attr2 = doc.createAttribute("Name");
			        attr2.setValue(tablename);
			        schema.setAttributeNode(attr2);
			        // have to put it in credentials.properties as table name is picked up by core and parser from there
			        Properties prop = new Properties();
			        InputStream input = new FileInputStream("credentials.properties");
			        prop.load(input);
			        prop.setProperty("Schema", tablename);
			        input.close();
			        
			        Element user = doc.createElement("username");
			        rootElement.appendChild(user);
			        
			        Attr attr3 = doc.createAttribute("Name");
			        attr3.setValue(param.get("username"));
			        user.setAttributeNode(attr3);
			        
			        Element pass = doc.createElement("Password");
			        rootElement.appendChild(pass);
			        
			        Attr attr4 = doc.createAttribute("Name");
			        attr4.setValue(param.get("password"));
			        pass.setAttributeNode(attr4);
			        
			        // global param ends here
			        
			        
			        Element column = doc.createElement("Column");
			        rootElement.appendChild(column);
			        
			        Element name = doc.createElement("Column-Name");
			        //Attr attrType = doc.createAttribute("Name");
			        //attrType.setValue(ColName);
			        //name.setAttributeNode(attrType);
			        name.appendChild(doc.createTextNode(colname));
			        column.appendChild(name);
			        
			        String verification;
			        if(verified == true){
			        	
			        	verification = "Y";
			        	
			        	
			        }
			        else 
		        		verification = "N";
			        
			        Element type = doc.createElement("Verified");
			        //Attr attrType = doc.createAttribute("Name");
			        //attrType.setValue(ColName);
			        //name.setAttributeNode(attrType);
			        type.appendChild(doc.createTextNode(verification));
			        column.appendChild(type);
			        
			        Element primary = doc.createElement("Start-From");
			        //Attr attrType = doc.createAttribute("Name");
			        //attrType.setValue(ColName);
			        //name.setAttributeNode(attrType);
			        primary.appendChild(doc.createTextNode(Integer.toString(seed)));
			        
			        column.appendChild(primary);
			        
			        TransformerFactory transformerFactory = TransformerFactory.newInstance();
			        Transformer transformer = transformerFactory.newTransformer();
			        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			        transformer.setOutputProperty(OutputKeys.METHOD, "xml");
			        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
			        DOMSource source = new DOMSource(doc);
			        StreamResult result = new StreamResult(new File("process-auto-increment.xml"));
			        transformer.transform(source, result);
			        
			        StreamResult consoleResult = new StreamResult(System.out);
			        transformer.transform(source, consoleResult);
			        
				
				
				
			}
				catch(Exception e){
					e.printStackTrace();
				}
	}
	
	

}
