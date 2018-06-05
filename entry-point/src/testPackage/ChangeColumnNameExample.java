package testPackage;
import process.process;

public class ChangeColumnNameExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Define the table name, current name of column and the name you want to change it to
		String _tableName = "newTestProcess";
		String _oldName = "col_1";
		String _newName = "column_1";
		
		
		// Call the function to change it
		process.ChangeColumnName(_tableName, _oldName, _newName);

	}

}
