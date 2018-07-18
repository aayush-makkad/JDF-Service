package tables;
import com.fasterxml.jackson.annotation.JsonIgnore;
public class service{
    int col_11= 0;   boolean col_11_bool = false;
    public int getcol_11(){
       return col_11;
  }
    public void setcol_11(int _col_11){
      this.col_11 =  _col_11;      this.col_11_bool=true;
  }
		@JsonIgnore
    public boolean iscol_11_bool(){return this.col_11_bool;}

 }