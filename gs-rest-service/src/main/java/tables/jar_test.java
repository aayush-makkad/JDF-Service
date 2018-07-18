package tables;
import com.fasterxml.jackson.annotation.JsonIgnore;
public class jar_test{
    int jar_test= 0;   boolean jar_test_bool = false;
    public int getjar_test(){
       return jar_test;
  }
    public void setjar_test(int _jar_test){
      this.jar_test =  _jar_test;      this.jar_test_bool=true;
  }
		@JsonIgnore
    public boolean isjar_test_bool(){return this.jar_test_bool;}

 }