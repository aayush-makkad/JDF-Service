package logical.operations;

import java.sql.ResultSet;
import java.sql.SQLException;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SQLStringBuildProcessor.SelectFromBuild("test_table", "six_test");
		SQLStringBuildProcessor.SelectWhereBuild("not first_test", "1");
		
		SQLStringBuildProcessor.SelectANDBuild("not five_test", "3");
	//	SQLStringBuildProcessor.SelectLike("col_2", "%a");
		
		System.out.println(SQLStringHolder.getmainString());
		ResultSet rs = StringBuilderJDBCProcessor.mainProcess();
		try {
			while(rs.next()){
				System.out.println(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
