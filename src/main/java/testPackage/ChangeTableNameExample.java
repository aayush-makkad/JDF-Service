package testPackage;
import process.process;
public class ChangeTableNameExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Define the current and new name for table
		String _currentName = "testProcess_2";
		String _newName = "newTestProcess";
		
		
		// Call the function for changing name
		process.ChangeTableName(_newName, _currentName);
		
		
		
	}

}
