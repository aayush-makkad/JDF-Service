/**
 * 
 */
package xml.processing;

/**
 * @author aayush
 *
 */
public class AutoIncrementStorageClass {
	
	
	
	static String ConnectionString;
	public static String getConnectionString() {
		return ConnectionString;
	}
	public static void setConnectionString(String connectionString) {
		ConnectionString = connectionString;
	}
	public static String getUsername() {
		return username;
	}
	public static void setUsername(String username) {
		AutoIncrementStorageClass.username = username;
	}
	public static String getPassword() {
		return password;
	}
	public static void setPassword(String password) {
		AutoIncrementStorageClass.password = password;
	}
	public static String getTableName() {
		return tableName;
	}
	public static void setTableName(String tableName) {
		AutoIncrementStorageClass.tableName = tableName;
	}
	public static String getColumnName() {
		return ColumnName;
	}
	public static void setColumnName(String columnName) {
		ColumnName = columnName;
	}
	public static int getSeed() {
		return seed;
	}
	public static void setSeed(int seed) {
		AutoIncrementStorageClass.seed = seed;
	}
	static String username;
	static String password;
	static String tableName;
	static String ColumnName;
	static int seed;
	
	

}
