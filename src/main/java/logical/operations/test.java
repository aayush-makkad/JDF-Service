package logical.operations;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SQLStringBuildProcessor.SelectFromBuild("test_table", "first_test");
		//SQLStringBuildProcessor.SelectWhereBuild("not first_test", "1");
		
		
		ArrayList<Object> _try = new ArrayList<Object>();
			_try.add(198);
			_try.add(199);
			_try.add(19889);
			_try.add("supp");
	//	SQLStringBuildProcessor.SelectLike("col_2", "%a");
		SQLStringBuildProcessor.SelectIn("first_test",_try);
		
		SQLStringBuildProcessor.SelectANDBuild("not first_test", "198");
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
