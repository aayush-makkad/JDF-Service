package tables;
import com.fasterxml.jackson.annotation.JsonIgnore;
public class tabb_2{
    String use_two= null;   boolean use_two_bool = false;
    public String getuse_two(){
       return use_two;
  }
    public void setuse_two(String _use_two){
      this.use_two =  _use_two;      this.use_two_bool=true;
  }
		@JsonIgnore
    public boolean isuse_two_bool(){return this.use_two_bool;}

 }