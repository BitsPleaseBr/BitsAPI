package bits.api.cadastro.verificacoes.login;

import bits.api.cadastro.CadastroResponse;

public class LoginResponse extends CadastroResponse {

  
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