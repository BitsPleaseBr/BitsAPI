package s3.api.cadastro.verificacoes.email;

import s3.api.cadastro.CadastroRequest;

public class VerEmailRequest extends CadastroRequest {

  
  private String email;
  
  
  public VerEmailRequest(String email) {
    
    this.email = email;
  }
  
  
  public void setEmail(String email) {
    
    this.email = email;
  }
  
  public String getEmail() {
    
    return this.email;
  }
  
  
  public VerEmailRequest() {}
}