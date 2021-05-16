package mappedclass.engine;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;


import framework.core.jdbc.*;

public class MappingEngine {
	
	 static String table_name = null;
	 static String todaySource = null;
	 static String todaySourceClass = null;
	 static String todayClass = null;
	 static String packageName = "tables";
	 static HashMap<String,String> colData = null;
	 static File dir;
	 static File dir2;
	
	public MappingEngine(){
		
		// Column Name and their respective java mapped data types
		colData = jdbcCore.getJavaMappedColumns();
	
//	for (Entry<String, String> entry : colData.entrySet()) {
//	    System.out.println(entry.getKey());
//	     System.out.println(entry.getValue());
//	    
//	}
	
	Properties prop = new Properties();
	InputStream input = null;
	try{
	input = new FileInputStream("credentials.properties");
	prop.load(input);
	table_name = prop.getProperty("Schema");
	todaySource = table_name + ".java";
	todaySourceClass = table_name+".class";
	String s = System.getProperty("user.dir");
	dir = new File(s+"//src//main//java//tables");
	dir2 = new File(s+"//target//classes//tables");
	System.out.println("Writing java file in "+dir.toString());
	todayClass = table_name;
	createIt();
	
	}
	catch(Exception e){
		e.printStackTrace();
	}
	
	
	
	
	}
	
	 public static void createIt() {
		    try {
		    	
		    	//creating Property file for binding(Mapping)
		    	
		    	
		    	OutputStream os = null;
		    	Properties prop = new Properties();
		    		
		    	
		    	// writing to java file 
		      FileWriter aWriter = new FileWriter(new File(dir,todaySource));
		      aWriter.write("package "+packageName+";");
		      aWriter.write(System.getProperty( "line.separator" ));
		      aWriter.write("import com.fasterxml.jackson.annotation.JsonIgnore;");
		      aWriter.write(System.getProperty( "line.separator" ));
		      aWriter.write("public class "+ todayClass + "{");
		      aWriter.write(System.getProperty( "line.separator" ));
//		      aWriter.write(" public void doit() {");
//		      aWriter.write(" System.out.println(\""+todayMillis+"\");");
		  	for (Entry<String, String> entry : colData.entrySet()) {
			    String col_name = entry.getKey();
			    prop.setProperty(col_name, col_name);
			    
			   // prop.setProperty("getters", "available");
			  //  prop.setProperty(col_name, "get"+col_name);
			 //   prop.setProperty("setters", "available");
			    //prop.setProperty(col_name, "set"+col_name);
			     String data_type = entry.getValue();
			     prop.setProperty("pm_type_"+col_name,data_type);
			     if(data_type.equalsIgnoreCase("String"))
			    	 aWriter.write("    "+data_type+" "+col_name+"= null;");
			     else if(data_type.equalsIgnoreCase("int"))
			    	 aWriter.write("    "+data_type+" "+col_name+"= 0;");
			     aWriter.write("   boolean "+col_name+"_bool = false;");
			     aWriter.write(System.getProperty( "line.separator" ));
			     aWriter.write("    public "+data_type+" get"+col_name+"(){");
			     aWriter.write(System.getProperty( "line.separator" ));
			     aWriter.write("       return "+col_name+";");
			     aWriter.write(System.getProperty( "line.separator" ));
			     aWriter.write("  }");
			     aWriter.write(System.getProperty( "line.separator" ));
			     aWriter.write("    public void set"+col_name+"("+data_type+" _"+col_name+"){");
			     aWriter.write(System.getProperty( "line.separator" ));
			     aWriter.write("      this."+col_name+" =  _"+col_name+";");
			     aWriter.write("      this."+col_name+"_bool=true;");
			     aWriter.write(System.getProperty( "line.separator" ));
			     aWriter.write("  }");
			     aWriter.write(System.getProperty( "line.separator" ));
			     aWriter.write("		@JsonIgnore");
			     aWriter.write(System.getProperty( "line.separator" ));
			     aWriter.write("    public boolean is"+col_name+"_bool()");
			     aWriter.write("{");
			     aWriter.write("return this."+col_name+"_bool;");
			     aWriter.write("}");
			     aWriter.write(System.getProperty( "line.separator" ));
			     aWriter.write(System.getProperty( "line.separator" ));
			     
			     
			     
			    
			}
		      
		      
		      aWriter.write(" }");
		      aWriter.flush();      
		      aWriter.close();
		      try{
		    	  os = new FileOutputStream(table_name+".properties");
		    	  prop.store(os, "Bindings for "+table_name);
		    	  os.close();
		      }catch(Exception e)
		      {
		    	  e.printStackTrace();
		      }
		      System.out.println("now compiling the class file");
		      compileIt();
		      }
		    catch(Exception e){
		      e.printStackTrace();
		      }
		    }
	 public static void compileIt() {
		 
		 
		 try{
		 JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		 compiler.run(null, null, null,dir+"//"+todaySource);
		 System.out.println("File compiled.. now moving to bin/tables folder");
		 Files.move(Paths.get(dir+"//"+todaySourceClass),Paths.get(dir2+"//"+todaySourceClass), StandardCopyOption.REPLACE_EXISTING);
		 System.out.println("Class file moved");
		
		 
		 }
		 catch(Exception e){
			 e.printStackTrace();
		 }
		    }	
	 
	 
	 public static void MappingSupportMethod(String tableName,HashMap<String,String> metaData){
		 
		 	table_name = tableName;
		 	todaySource = tableName + ".java";
			todaySourceClass = tableName+".class";
			String s = System.getProperty("user.dir");
			dir = new File(s+"//src//main//java//tables");
			dir2 = new File(s+"//target//classes//tables");
			System.out.println("Writing java file in "+dir.toString());
			todayClass = tableName;
			colData = metaData;
			createIt();
		 
		 
	 }
	 
	

}
