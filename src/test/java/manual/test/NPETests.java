package manual.test;

import java.io.FileNotFoundException;

import entry.input.MappingPropertyHandler;

public class NPETests {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		try {
			new MappingPropertyHandler("jdbc:mysql://localhost:3306/mydb","mydb","root","pass");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
