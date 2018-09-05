package bits.api.selecionar.selecoes.login;

import bits.api.selecionar.SelecionarResponse;

public class LoginResponse extends SelecionarResponse {

  
  private int id;
  
  
  public LoginResponse(boolean sucesso, int id) {
    
    setLambdaInvocada("Lambda para Login de usuário");
    this.id = id;
    this.sucesso = sucesso;
  }
  
  
  public void setId(int id) {
    
    this.id = id;
  }
  
  public int getId() {
    
    return this.id;
  }
  
  
  public LoginResponse() {
    
    setLambdaInvocada("Lambda para Login de usuário");
  }
}