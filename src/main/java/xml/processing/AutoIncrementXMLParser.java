package xml.processing;
import framework.core.jdbc.AutoIncrementJDBCCore;

import java.io.File;
import java.util.ArrayList;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import entry.input.AutoIncrementMetaData;
import sanitycheck.autoIncrement.*;


public class AutoIncrementXMLParser {
	
	static ArrayList<AutoIncrementMetaData> readColumnAutoIncrement = new ArrayList<AutoIncrementMetaData>();

	public static void main(String[] args) {
		
		
		
		try{
			
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			
			String filePath = "process-auto-increment.xml";
	        File xmlFile = new File(filePath);
	        Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nodeList = doc.getElementsByTagName("Column");
        
           
			for(int i=0;i<nodeList.getLength();i++){
				readColumnAutoIncrement.add(getMetaData(nodeList.item(i)));
			}
			
			for(AutoIncrementMetaData cmd : readColumnAutoIncrement){
				
				System.out.println(cmd.getColName());
				System.out.println(cmd.getVerified());
				System.out.println(cmd.getSeed());
				
				// XMLStorageListCreator.StoredArrayListCreator(cmd.getName(),cmd.getDataType(), cmd.isIdentity());
				
			}
			
			boolean sanityCheckResult = false;
			
			sanityCheckResult = XMLCredentialPropertiesSchema.SanityCheckRun();
			if(sanityCheckResult){
				
				// run jdbc core process for autoincrement here
				
				AutoIncrementJDBCCore.CoreProcess();
				
				
				
				
			}
			else
			{
				System.out.println("Sanity check failed! Please make sure schema name in XML and Credentials.properties is same.");
				
			}
			
			
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		
		// TODO Auto-generated method stub

	}
	
	public static ArrayList<AutoIncrementMetaData> getMainArrayList(){
		
		return readColumnAutoIncrement;
		
		
	}
	
	private static AutoIncrementMetaData getMetaData(Node node) {
		// TODO Auto-generated method stub
//		Element element1 = (Element) node;
//        System.out.println(element1.getAttribute("Name"));
		
		AutoIncrementMetaData cmd = new AutoIncrementMetaData();
		if (node.getNodeType() == Node.ELEMENT_NODE) {
			
            Element element = (Element) node;
            //System.out.println(element.getAttribute("Schema"));
            cmd.setColName(getTagValue("Column-Name",element));
            cmd.setVerified(getTagValue("Verified",element));
            cmd.setSeed(Integer.parseInt(getTagValue("Start-From",element)));
		}
		
            
		return cmd;
		
		
	}
	
	private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return node.getNodeValue();
    }

}
