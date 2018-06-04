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
	String defaultvalue;
	public String getDefaultvalue() {
		return defaultvalue;
	}
	public void setDefaultvalue(String defaultvalue) {
		this.defaultvalue = defaultvalue;
	}
	boolean isIdentity;
	
	/**
	 * 
	 * @param cname
	 * @param dtype
	 * @param primary
	 * @param def
	 */
	ColumnMetaData(String cname,String dtype,boolean primary,String def){
		
		this.name = cname;
		this.dataType = dtype;
		this.isIdentity = primary;
		this.defaultvalue = def;
		
	}
	
	 public ColumnMetaData(){
		
	}
	
	
}
