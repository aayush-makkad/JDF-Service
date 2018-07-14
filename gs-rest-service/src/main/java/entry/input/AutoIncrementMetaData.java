package entry.input;

public class AutoIncrementMetaData {
	
	String ColName;
	
	
	public String getColName() {
		return ColName;
	}
	public void setColName(String colName) {
		ColName = colName;
	}
	public String getVerified() {
		return verified;
	}
	public void setVerified(String verified) {
		this.verified = verified;
	}
	public int getSeed() {
		return seed;
	}
	public void setSeed(int seed) {
		this.seed = seed;
	}
	String verified;
	int seed;

}
