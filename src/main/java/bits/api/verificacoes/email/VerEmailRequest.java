package bits.api.verificacoes.email;

public class VerEmailRequest {

  
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