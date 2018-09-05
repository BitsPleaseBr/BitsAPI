package bits.api.cadastro.cadastros;

import bits.api.cadastro.CadastroResponse;

public class CadResponse extends CadastroResponse {

  
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