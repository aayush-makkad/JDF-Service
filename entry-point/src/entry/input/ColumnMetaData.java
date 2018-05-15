package entry.input;

public class ColumnMetaData {

	String name;
	public String getName() {
		return name;
	}
	public String getDataType() {
		return dataType;
	}
	public boolean isIdentity() {
		return isIdentity;
	}
	String dataType;
	boolean isIdentity;
	ColumnMetaData(String cname,String dtype,boolean primary){
		
		this.name = cname;
		this.dataType = dtype;
		this.isIdentity = primary;
		
	}
	
	
}
