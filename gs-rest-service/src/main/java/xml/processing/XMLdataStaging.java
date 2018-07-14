package xml.processing;
import framework.core.jdbc.*;
import mappedclass.engine.MappingEngine;
import java.io.File;
import java.util.ArrayList;

import entry.input.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class XMLdataStaging {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		try{
			
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			
			String filePath = "process-create.xml";
	        File xmlFile = new File(filePath);
	        Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nodeList = doc.getElementsByTagName("Column");
          // Main ArrayList
            ArrayList<ColumnMetaData> readColumn = new ArrayList<ColumnMetaData>();
			for(int i=0;i<nodeList.getLength();i++){
				readColumn.add(getMetaData(nodeList.item(i)));
			}
			
			for(ColumnMetaData cmd : readColumn){
				
				System.out.println(cmd.getName());
				System.out.println(cmd.getDataType());
				System.out.println(cmd.isIdentity());
				System.out.println(cmd.getDefaultvalue());
				
				XMLStorageListCreator.StoredArrayListCreator(cmd.getName(),cmd.getDataType(), cmd.isIdentity(),cmd.getDefaultvalue());
				
			}
			
			jdbcCore jdbccore = new jdbcCore();
			jdbccore.coreProcess();
			@SuppressWarnings("unused")
			MappingEngine me = new MappingEngine();
			
			
		}
		
		catch(Exception e){
			e.printStackTrace();
		}
		

	}

	private static ColumnMetaData getMetaData(Node node) {
		// TODO Auto-generated method stub
//		Element element1 = (Element) node;
//        System.out.println(element1.getAttribute("Name"));
		
		ColumnMetaData cmd = new ColumnMetaData();
		if (node.getNodeType() == Node.ELEMENT_NODE) {
			
            Element element = (Element) node;
            //System.out.println(element.getAttribute("Schema"));
            cmd.setName(getTagValue("Column-Name",element));
            cmd.setDataType(getTagValue("Column-Data-Type",element));
            cmd.setIdentity(getTagValue("Is-Primary-Key",element).equalsIgnoreCase("Y")?true:false);
            cmd.setDefaultvalue(getTagValue("Default",element));
		}
		
            
		return cmd;
		
		
	}
	
	private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return (node.getNodeValue()==null?"":node.getNodeValue());
    }

}
