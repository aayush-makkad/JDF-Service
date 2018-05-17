/**
 * 
 */
package entry.input;


import java.io.File;
import java.util.ArrayList;

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
public class MasterVerificationAutoIncrement {
	
	/**
	 * 
	 * @param return type boolean doesn't tells about verification status anymore here
	 * 
	 */
	public boolean MasterVerifier(String colname) {
		
		boolean flag = false;
		
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
				
				if(cmd.getName().equalsIgnoreCase(colname))
				{
					System.out.println(cmd.getName());
				
					System.out.println(cmd.getDataType());
					System.out.println(cmd.isIdentity());
					
					if(cmd.getDataType().equals("int") && cmd.isIdentity==true){
						
						flag = true;
						return flag;
						
					}
					
				}
			
			
			}
			
			
			
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		return flag;
	}
		
		
		ColumnMetaData getMetaData(Node node) {
			// TODO Auto-generated method stub
			
			ColumnMetaData cmd = new ColumnMetaData();
			if (node.getNodeType() == Node.ELEMENT_NODE) {
	            Element element = (Element) node;
	            cmd.setName(getTagValue("Column-Name",element));
	            cmd.setDataType(getTagValue("Column-Data-Type",element));
	            cmd.setIdentity(getTagValue("Is-Primary-Key",element).equalsIgnoreCase("Y")?true:false);
			}
			
	            
			return cmd;
			
			
		}
		
		String getTagValue(String tag, Element element) {
	        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
	        Node node1 = (Node) nodeList.item(0);
	        return node1.getNodeValue();
	    }

		
		
	}
	
	


