package tables;
import com.fasterxml.jackson.annotation.JsonIgnore;
public class test_table{
    int try_three= 0;   boolean try_three_bool = false;
    public int gettry_three(){
       return try_three;
  }
    public void settry_three(int _try_three){
      this.try_three =  _try_three;      this.try_three_bool=true;
  }
	@JsonIgnore
    public boolean istry_three_bool(){return this.try_three_bool;}

    int six_test= 0;   boolean six_test_bool = false;
    public int getsix_test(){
       return six_test;
  }
    public void setsix_test(int _six_test){
      this.six_test =  _six_test;      this.six_test_bool=true;
  }
		@JsonIgnore
    public boolean issix_test_bool(){return this.six_test_bool;}

    String try_two= null;   boolean try_two_bool = false;
    public String gettry_two(){
       return try_two;
  }
    public void settry_two(String _try_two){
      this.try_two =  _try_two;      this.try_two_bool=true;
  }
		@JsonIgnore
    public boolean istry_two_bool(){return this.try_two_bool;}

    int five_testt3= 0;   boolean five_testt3_bool = false;
    public int getfive_testt3(){
       return five_testt3;
  }
    public void setfive_testt3(int _five_testt3){
      this.five_testt3 =  _five_testt3;      this.five_testt3_bool=true;
  }
		@JsonIgnore
    public boolean isfive_testt3_bool(){return this.five_testt3_bool;}

    int first_test= 0;   boolean first_test_bool = false;
    public int getfirst_test(){
       return first_test;
  }
    public void setfirst_test(int _first_test){
      this.first_test =  _first_test;      this.first_test_bool=true;
  }
		@JsonIgnore
    public boolean isfirst_test_bool(){return this.first_test_bool;}

 }