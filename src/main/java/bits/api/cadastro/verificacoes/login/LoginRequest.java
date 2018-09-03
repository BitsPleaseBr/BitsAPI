package bits.api.cadastro.verificacoes.login;

import bits.api.cadastro.CadastroRequest;

public class LoginRequest extends CadastroRequest {

  
  private String email, senha;
  
  
  public LoginRequest(String email, String senha) {
    
    this.email = email;
    this.senha = senha;
  }
  
  
  public String getEmail() {
    
    return this.email;
  }
  
  public void setEmail(String email) {
    
    this.email = email;
  }
  
  
  public String getSenha() {
    
    return this.senha;
  }
  
  public void setSenha(String senha) {
    
    this.senha = senha;
  }
  
  
  public LoginRequest() {}
}