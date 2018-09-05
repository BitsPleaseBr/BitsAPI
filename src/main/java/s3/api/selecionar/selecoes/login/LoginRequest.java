package s3.api.selecionar.selecoes.login;

import s3.api.cadastro.CadastroRequest;

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