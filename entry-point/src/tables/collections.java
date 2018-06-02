package tables;
public class collections{
    int hash_map= 0;   boolean hash_map_bool = false;
    public int gethash_map(){
       return hash_map;
  }
    public void sethash_map(int _hash_map){
      this.hash_map =  _hash_map;      this.hash_map_bool=true;
  }
    public boolean ishash_map_bool(){return this.hash_map_bool;}

    int linked_list= 0;   boolean linked_list_bool = false;
    public int getlinked_list(){
       return linked_list;
  }
    public void setlinked_list(int _linked_list){
      this.linked_list =  _linked_list;      this.linked_list_bool=true;
  }
    public boolean islinked_list_bool(){return this.linked_list_bool;}

 }