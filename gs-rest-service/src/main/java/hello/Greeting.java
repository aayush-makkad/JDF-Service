package hello;

public class Greeting {
	
	
	private final long id;
    /**
	 * @param id
	 * @param content
	 */
	public Greeting(long id, String content) {
		super();
		this.id = id;
		this.content = content;
	}
	private final String content;
	public long getId() {
		return id;
	}
	public String getContent() {
		return content;
	}
	
	
	
}
