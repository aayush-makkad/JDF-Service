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
	public void setName(String name) {
		this.name = name;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public void setIdentity(boolean isIdentity) {
		this.isIdentity = isIdentity;
	}
	String dataType;
	boolean isIdentity;
	ColumnMetaData(String cname,String dtype,boolean primary){
		
		this.name = cname;
		this.dataType = dtype;
		this.isIdentity = primary;
		
	}
	
	 public ColumnMetaData(){
		
	}
	
	
}
