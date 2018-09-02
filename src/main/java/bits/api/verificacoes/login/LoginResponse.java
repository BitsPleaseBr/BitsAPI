package bits.api.verificacoes.login;

public class LoginResponse {

  
  private int id;
  private boolean sucesso;
  
  
  public LoginResponse(boolean sucesso, int id) {
    
    this.id = id;
    this.sucesso = sucesso;
  }
  
  
  public void setId(int id) {
    
    this.id = id;
  }
  
  public int getId() {
    
    return this.id;
  }
  
  
  public void setSucesso(boolean sucesso) {
    
    this.sucesso = sucesso;
  }
  
  public boolean getSucesso() {
    
    return this.sucesso;
  }
  
  
  public LoginResponse() {}
}