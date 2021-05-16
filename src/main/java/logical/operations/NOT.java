package logical.operations;

public class NOT {
	
	
	int IntegerVal = 0;
	String StringVal = null;
	int UpperVal = 0;
	int LowerVal = 0;
	char charValue ;
	char LowerChar;
	char UpperChar;
	String Initialized = null;
	
	public int getIntegerVal() {
		return IntegerVal;
	}
	public String getStringVal() {
		return StringVal;
	}
	public int getUpperVal() {
		return UpperVal;
	}
	public int getLowerVal() {
		return LowerVal;
	}
	public char getCharValue() {
		return charValue;
	}
	public char getLowerChar() {
		return LowerChar;
	}
	public char getUpperChar() {
		return UpperChar;
	}
	
	NOT(int i){
		this.IntegerVal = i;
		Initialized = "integer";
	}
	NOT(String s){
		this.StringVal = s;
		Initialized = "String";
	}
	NOT(char c){
		this.charValue = c;
		Initialized = "char";
	}
	
	

}
