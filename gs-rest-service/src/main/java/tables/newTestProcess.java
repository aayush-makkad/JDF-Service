package tables;
import com.fasterxml.jackson.annotation.JsonIgnore;
public class newTestProcess{
    int col_2= 0;   boolean col_2_bool = false;
    public int getcol_2(){
       return col_2;
  }
    public void setcol_2(int _col_2){
      this.col_2 =  _col_2;      this.col_2_bool=true;
  }
		@JsonIgnore
    public boolean iscol_2_bool(){return this.col_2_bool;}

    int column_1= 0;   boolean column_1_bool = false;
    public int getcolumn_1(){
       return column_1;
  }
    public void setcolumn_1(int _column_1){
      this.column_1 =  _column_1;      this.column_1_bool=true;
  }
		@JsonIgnore
    public boolean iscolumn_1_bool(){return this.column_1_bool;}

 }