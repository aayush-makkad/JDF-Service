package framework.core.jdbc;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import entry.input.DataTypeArgumentChecker;
import xml.processing.*;

public class jdbcCore {
	
	private static ArrayList<XMLDataStorageClass> data;
	public static ArrayList<XMLDataStorageClass> getData() {
		return data;
	}

	public static HashMap<String, String> getJavaMappedColumns() {
		return JavaMappedColumns;
	}

	public static HashMap<String,String> JavaMappedColumns;
	
	public jdbcCore(){
	
	 data = XMLStorageListCreator.getFinalData();
	 
	 
	}
	
	public boolean coreProcess(){
		
		XMLDataStorageClass xss = new XMLDataStorageClass();
		Connection con = null;
		String tableName = data.get(0).getSchema();
		StringBuffer sqlbuff = new StringBuffer();
				sqlbuff.append("create table "+tableName+" ( ");
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			 con = (Connection) DriverManager.getConnection(data.get(0).getConnectionString(),data.get(0).getUsername(),data.get(0).getPassword());
			
		
			Iterator<XMLDataStorageClass> it = data.iterator();
			String prime = null;
			
			String dfVal="";
			if(data.size()>1){
			while(it.hasNext()){
				
				
				prime = null;
				xss = (XMLDataStorageClass) it.next();
				if(xss.getPrime()){
					prime = "PRIMARY KEY";
				}
				else{
					prime = "";
				}
				 dfVal="";
				 String XMLDefVal = xss.getDefaultVal().trim();
			
				 
				 if(xss.getDefaultVal().trim().equalsIgnoreCase("not null".trim()))
					{
						dfVal = xss.getDefaultVal();
					}
				 
				 else{
				 
				 if(XMLDefVal.equalsIgnoreCase("NOT SET"))
				 {
					 dfVal="";
					 
				 }
				 else
				 {
					 
					 
					 
					 if(DataTypeArgumentChecker.DefaultTextOrNumerical(xss.getDataType()).startsWith("comma"))
						 dfVal = "DEFAULT '"+xss.getDefaultVal()+"'";
					
					 if(DataTypeArgumentChecker.DefaultTextOrNumerical(xss.getDataType()).startsWith("no"))
							 dfVal = "DEFAULT "+xss.getDefaultVal();
						 
					 
				 }
				
				 }
				 
					 
					 
						 
						 
						 
						 
						 
					 
					 
					 
				 
				 
				 if(!it.hasNext()){
						//last iteration
						
						sqlbuff.append(xss.getColumnName()+" "+xss.getDataType()+" "+prime+" "+dfVal+" )" );
						
					}else
					{
						sqlbuff.append(xss.getColumnName()+" "+xss.getDataType()+" "+prime+" "+dfVal+" , ");
					}
				
				
			}
			}
				 
			
			else
			{
				String primeOne = null;
				if(data.get(0).getPrime()){
					primeOne = "PRIMARY KEY";
					
				}
				else{
					primeOne = "";
				}
				 dfVal="";
				if(data.get(0).getDefaultVal().equalsIgnoreCase("not null"))
				{
					dfVal = data.get(0).getDefaultVal();
				}
				else if(!data.get(0).getDefaultVal().equalsIgnoreCase("NOT SET") && DataTypeArgumentChecker.DefaultTextOrNumerical(data.get(0).getDataType()).startsWith("comma"))
				{
					dfVal = "DEFAULT '"+data.get(0).getDefaultVal()+"'";
				}
				else if(!data.get(0).getDefaultVal().equalsIgnoreCase("NOT SET") && DataTypeArgumentChecker.DefaultTextOrNumerical(data.get(0).getDataType()).startsWith("no")){
					dfVal = "DEFAULT "+data.get(0).getDefaultVal();
				}
				sqlbuff.append(data.get(0).getColumnName()+" "+data.get(0).getDataType()+" "+primeOne+" "+dfVal+") ");
			}
			
			
			
			Statement st = (Statement) con.createStatement();
			st.executeUpdate(sqlbuff.toString());
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		System.out.println(sqlbuff);
		JavaMappedColumns = HashMapCreationProcess();
		return true;
		
	}
	
	
	public HashMap<String,String> HashMapCreationProcess(){
		
		HashMap<String,String> hs = new HashMap<String,String>();
		@SuppressWarnings("rawtypes")
		Iterator it = data.iterator();
		XMLDataStorageClass xss = new XMLDataStorageClass();
		while(it.hasNext()){
			
			xss = (XMLDataStorageClass)it.next();
			
			hs.put(xss.getColumnName(), JavaMappedDataType(xss.getDataType()));
			
		}
		return hs;
		
		
		
	}

	private String JavaMappedDataType(String dataType) {
		// TODO Auto-generated method stub
		dataType = dataType.toLowerCase();
		if(dataType.startsWith("int"))
			return "int";
		if(dataType.startsWith("varchar"))
			return "String";
		else 
			return "invalid"; 
		
		
		
	}
	
	

}
