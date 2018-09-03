package bits.api.cadastros;

import bits.api.Response;

public class CadResponse extends Response {

  
  protected int id;
  
  
  public CadResponse(boolean sucesso, int id) {
    
    this.sucesso = sucesso;
    this.id = id;
  }
  
  
  public void setId(int id) {
    
    this.id = id;
  }
  
  public int getId() {
    
   return this.id;
  }
  
  public CadResponse() {}
}