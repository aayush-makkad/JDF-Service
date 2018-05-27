package entry.input;
import framework.core.jdbc.*;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;

public class DropTableInputHelper {
	
	
	
	public static void TableDrop(String _tableName){
		boolean res = false;
		System.out.println("Deleting table "+_tableName+" from sql");
		res = DropTableJDBC(_tableName);
		if(res){
			System.out.println("Table Deleted from sql");
			System.out.println("Now deleting binding file for "+_tableName);
			BindingDeletion(_tableName);
			System.out.println("Binding file deletion method was run");
		}
		else
		{
			System.out.println("Failed to delete sql table");
		}
		
		
		
	}
	
	
	public static void BindingDeletion(String _tableName){
		
		
		 try
	        {
	            Files.deleteIfExists(Paths.get(_tableName+".properties"));
	        }
	        catch(NoSuchFileException e)
	        {
	            System.out.println("No such file/directory exists");
	        }
	        catch(DirectoryNotEmptyException e)
	        {
	            System.out.println("Directory is not empty.");
	        }
	        catch(IOException e)
	        {
	            System.out.println("Invalid permissions.");
	        }
	         
	        System.out.println("Deletion successful.");
	    }
	
	public static boolean DropTableJDBC(String _tableName){
		
		boolean res = false;
		res = DropTableJDBCSupportClass.DropTableHelper(_tableName);
		return res;
		
		
	}
	
	

}
