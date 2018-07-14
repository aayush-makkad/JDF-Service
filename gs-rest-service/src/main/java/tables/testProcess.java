package tables;
public class testProcess{
    int col_2= 0;   boolean col_2_bool = false;
    public int getcol_2(){
       return col_2;
  }
    public void setcol_2(int _col_2){
      this.col_2 =  _col_2;      this.col_2_bool=true;
  }
    public boolean iscol_2_bool(){return this.col_2_bool;}

    int col_1= 0;   boolean col_1_bool = false;
    public int getcol_1(){
       return col_1;
  }
    public void setcol_1(int _col_1){
      this.col_1 =  _col_1;      this.col_1_bool=true;
  }
    public boolean iscol_1_bool(){return this.col_1_bool;}

 }