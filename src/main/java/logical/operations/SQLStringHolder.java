package logical.operations;

public class SQLStringHolder {
	
	
	
	
	private static StringBuilder _mainString = new StringBuilder();

	public static StringBuilder getmainString() {
		return _mainString;
	}

	public static void setMainString(String s){
		SQLStringHolder._mainString.append(" "+s);
	}
	
	

}
