package tables;
public class tscm_default_final_test{
    String tscm_kucka= null;   boolean tscm_kucka_bool = false;
    public String gettscm_kucka(){
       return tscm_kucka;
  }
    public void settscm_kucka(String _tscm_kucka){
      this.tscm_kucka =  _tscm_kucka;      this.tscm_kucka_bool=true;
  }
    public boolean istscm_kucka_bool(){return this.tscm_kucka_bool;}

    int tscm_hyperReal= 0;   boolean tscm_hyperReal_bool = false;
    public int gettscm_hyperReal(){
       return tscm_hyperReal;
  }
    public void settscm_hyperReal(int _tscm_hyperReal){
      this.tscm_hyperReal =  _tscm_hyperReal;      this.tscm_hyperReal_bool=true;
  }
    public boolean istscm_hyperReal_bool(){return this.tscm_hyperReal_bool;}

 }