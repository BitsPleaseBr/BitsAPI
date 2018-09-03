package bits.api.verificacoes.login;

import bits.api.Response;

public class LoginResponse extends Response {

  
  private int id;
  
  
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
  
  
  public LoginResponse() {}
}