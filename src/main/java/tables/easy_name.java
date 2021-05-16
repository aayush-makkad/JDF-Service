package tables;
import com.fasterxml.jackson.annotation.JsonIgnore;
public class easy_name{
    int try_three= 0;   boolean try_three_bool = false;
    public int gettry_three(){
       return try_three;
  }
    public void settry_three(int _try_three){
      this.try_three =  _try_three;      this.try_three_bool=true;
  }
		@JsonIgnore
    public boolean istry_three_bool(){return this.try_three_bool;}

    String change_col= null;   boolean change_col_bool = false;
    public String getchange_col(){
       return change_col;
  }
    public void setchange_col(String _change_col){
      this.change_col =  _change_col;      this.change_col_bool=true;
  }
		@JsonIgnore
    public boolean ischange_col_bool(){return this.change_col_bool;}

 }