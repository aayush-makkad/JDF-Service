package framework.core.jdbc;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Iterator;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import xml.processing.*;

public class jdbcCore {
	
	private static ArrayList<XMLDataStorageClass> data;
	
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
//			Class.forName("com.mysql.jdbc.Driver");
//			 con = (Connection) DriverManager.getConnection(data.get(0).getConnectionString(),data.get(0).getUsername(),data.get(0).getPassword());
			
		
			Iterator<XMLDataStorageClass> it = data.iterator();
			String prime = null;
			String def ;
			
			if(data.size()>1){
			while(it.hasNext()){
				def = "";
				
				prime = null;
				xss = (XMLDataStorageClass) it.next();
				if(xss.getPrime()){
					prime = "PRIMARY KEY";
				}
				else{
					prime = "";
				}
				String dfVal="";
				if(xss.getDefaultVal().equalsIgnoreCase("not null"))
				{
					dfVal = xss.getDefaultVal();
				}
				 if(!xss.getDefaultVal().equalsIgnoreCase("NOT SET") && xss.getDataType().equalsIgnoreCase("varchar"))
				{
					dfVal = "DEFAULT '"+xss.getDefaultVal()+"'";
				}
				 if((!xss.getDefaultVal().equalsIgnoreCase("NOT SET")) && xss.getDataType().equalsIgnoreCase("int")){
					dfVal = "DEFAULT "+xss.getDefaultVal();
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
				String dfVal="";
				if(data.get(0).getDefaultVal().equalsIgnoreCase("not null"))
				{
					dfVal = data.get(0).getDefaultVal();
				}
				else if(!data.get(0).getDefaultVal().equalsIgnoreCase("") && data.get(0).getDataType().equalsIgnoreCase("varchar"))
				{
					dfVal = "DEFAULT '"+data.get(0).getDefaultVal()+"'";
				}
				else if(!data.get(0).getDefaultVal().equalsIgnoreCase("") && data.get(0).getDataType().equalsIgnoreCase("int")){
					dfVal = "DEFAULT "+data.get(0).getDefaultVal();
				}
				sqlbuff.append(data.get(0).getColumnName()+" "+data.get(0).getDataType()+" "+primeOne+" "+dfVal+") ");
			}
			
			
			
//			Statement st = (Statement) con.createStatement();
//			st.executeUpdate(sqlbuff.toString());
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		System.out.println(sqlbuff);
		return true;
		
	}

}
