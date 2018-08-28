package bits.api.cadastros;

public class CadResponse {

  protected boolean sucesso;
  protected int id;
  
  
  public CadResponse(boolean sucesso, int id) {
    
    this.sucesso = sucesso;
    this.id = id;
  }
  
  
  public void setSucesso(boolean sucesso) {
    
    this.sucesso = sucesso;
  }
  
  public boolean getSucesso() {
    
    return this.sucesso;
  }
  
  public void setId(int id) {
    
    this.id = id;
  }
  
  public int getId() {
    
   return this.id;
  }
  
  public CadResponse() {}
}