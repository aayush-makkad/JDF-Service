package tables;
import com.fasterxml.jackson.annotation.JsonIgnore;
public class tscm_tester_default{
    int tscm_int_non= 0;   boolean tscm_int_non_bool = false;
    public int gettscm_int_non(){
       return tscm_int_non;
  }
    public void settscm_int_non(int _tscm_int_non){
      this.tscm_int_non =  _tscm_int_non;      this.tscm_int_non_bool=true;
  }
		@JsonIgnore
    public boolean istscm_int_non_bool(){return this.tscm_int_non_bool;}

    String tscm_Var_def= null;   boolean tscm_Var_def_bool = false;
    public String gettscm_Var_def(){
       return tscm_Var_def;
  }
    public void settscm_Var_def(String _tscm_Var_def){
      this.tscm_Var_def =  _tscm_Var_def;      this.tscm_Var_def_bool=true;
  }
		@JsonIgnore
    public boolean istscm_Var_def_bool(){return this.tscm_Var_def_bool;}

    int tscm_plain= 0;   boolean tscm_plain_bool = false;
    public int gettscm_plain(){
       return tscm_plain;
  }
    public void settscm_plain(int _tscm_plain){
      this.tscm_plain =  _tscm_plain;      this.tscm_plain_bool=true;
  }
		@JsonIgnore
    public boolean istscm_plain_bool(){return this.tscm_plain_bool;}

 }