package tables;
public class test_table{
    int try_three= 0;
    boolean try_three_bool = false;
    boolean try_two_bool = false;
    boolean first_test_bool = false;
    boolean five_test_bool = false;
    boolean six_test_bool = false;
   
    	public boolean istry_three_bool(){
    		return try_three_bool;
    	}
    
    public int gettry_three(){
       return try_three;
  }
    public void settry_three(int _try_three){
      this.try_three =  _try_three;
      this.try_three_bool = true;
  }
    int six_test= 0;
    public int getsix_test(){
       return six_test;
  }
    public void setsix_test(int _six_test){
      this.six_test =  _six_test;
      this.six_test_bool = true;
  }
    int five_test= 0;
    public int getfive_test(){
       return five_test;
  }
    public void setfive_test(int _five_test){
      this.five_test =  _five_test;
      this.five_test_bool=true;
  }
    String try_two= null;
    public String gettry_two(){
       return try_two;
  }
    public void settry_two(String _try_two){
      this.try_two =  _try_two;
      this.try_two_bool=true;
  }
    int first_test= 0;
    public int getfirst_test(){
       return first_test;
  }
    public void setfirst_test(int _first_test){
      this.first_test =  _first_test;
      this.first_test_bool=true;
    }
    public boolean istry_two_bool() {
		return try_two_bool;
	}

	public boolean isfirst_test_bool() {
		return first_test_bool;
	}

	public boolean isfive_test_bool() {
		return five_test_bool;
	}

	public boolean issix_test_bool() {
		return six_test_bool;
	}

	public Object clone()throws CloneNotSupportedException{  
    	return super.clone();  
    	}
 }