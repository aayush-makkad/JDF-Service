/**
 * 
 */
package entry.xml;
import xml.processing.*;

import javax.xml.parsers.DocumentBuilderFactory;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import entry.input.*; 

/**
 * @author aayush
 *
 */
public class xmlGeneration {
	
	
	
//	static dataStaging ds = new dataStaging();
	static HashMap<String,String> param = dataStaging.getCredentialsFromProperties();
	static ArrayList<ColumnMetaData> columnData = dataStaging.getColumnData();
	
	
	public static void main(String args[]){
		createXML();
	}
	
	public static void createXML()
	{
	
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
		        
		        Iterator<ColumnMetaData> it = columnData.iterator();
		        String ColName;
		        String DataType;
		        boolean prime;
		        String defaultVal;
		        
		        while(it.hasNext()){
		        	
		        	ColumnMetaData cmd = (ColumnMetaData) it.next();
		        	ColName = cmd.getName();
		        	DataType = cmd.getDataType();
		        	prime = cmd.isIdentity();
		        	defaultVal = cmd.getDefaultvalue();
		        	String PrimeUsableType;
		        	if(prime == true){
		        		PrimeUsableType = "Y";
		        	}
		        	else
		        	{
		        		PrimeUsableType = "N";
		        	}
		        	
		        	Element column = doc.createElement("Column");
			        rootElement.appendChild(column);
			        
			        Element name = doc.createElement("Column-Name");
			        //Attr attrType = doc.createAttribute("Name");
			        //attrType.setValue(ColName);
			        //name.setAttributeNode(attrType);
			        name.appendChild(doc.createTextNode(ColName));
			        column.appendChild(name);
			        
			        Element type = doc.createElement("Column-Data-Type");
			        //Attr attrType = doc.createAttribute("Name");
			        //attrType.setValue(ColName);
			        //name.setAttributeNode(attrType);
			        type.appendChild(doc.createTextNode(DataType));
			        column.appendChild(type);
			        
			        Element primary = doc.createElement("Is-Primary-Key");
			        //Attr attrType = doc.createAttribute("Name");
			        //attrType.setValue(ColName);
			        //name.setAttributeNode(attrType);
			        primary.appendChild(doc.createTextNode(PrimeUsableType));
			        column.appendChild(primary);
			        
			        Element defaultValue = doc.createElement("Default");
			        //Attr attrType = doc.createAttribute("Name");
			        //attrType.setValue(ColName);
			        //name.setAttributeNode(attrType);
			        defaultValue.appendChild(doc.createTextNode(defaultVal));
			        column.appendChild(defaultValue);
			        
			        
		        	
		        	
		        }
		        
		        TransformerFactory transformerFactory = TransformerFactory.newInstance();
		        Transformer transformer = transformerFactory.newTransformer();
		        DOMSource source = new DOMSource(doc);
		        StreamResult result = new StreamResult(new File("process-create.xml"));
		        transformer.transform(source, result);
		        
		        StreamResult consoleResult = new StreamResult(System.out);
		        transformer.transform(source, consoleResult);
				XMLdataStaging.main(null);
				
				}
			catch(Exception e){
				e.printStackTrace();
			}
	}

}
