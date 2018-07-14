/**
 * 
 */
package entry.input;
import entry.xml.*;

import java.util.Scanner;

/**
 * @author aayush
 *
 */
public class EntryAutoIncrement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		String columnname;
		int seed = 1;
		
		System.out.println("Enter the column name");
		columnname = sc.nextLine();
		System.out.println("Enter the starting value");
		seed = sc.nextInt();
		
		
		
		IncrementDataHolder idc = new IncrementDataHolder(columnname,seed);
		MasterVerificationAutoIncrement mvai = new MasterVerificationAutoIncrement();
		System.out.println("verification result : "+mvai.MasterVerifier(idc.getColumnName()));
		boolean verified = false;
		if(mvai.MasterVerifier(idc.getColumnName())){
			verified = true;
			
			@SuppressWarnings("unused")
			AutoIncrementXMLCreator aixc = new AutoIncrementXMLCreator(idc.getColumnName(),idc.getStartingSeed(),verified);
			
			
		}
		
		sc.close();
		
		
		
		

	}

}
