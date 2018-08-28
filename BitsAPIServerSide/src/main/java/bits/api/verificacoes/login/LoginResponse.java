package bits.api.verificacoes.login;

public class LoginResponse {

  
  private int id;
  
  
  public LoginResponse(int id) {
    
    this.id = id;
  }
  
  
  public void setId(int id) {
    
    this.id = id;
  }
  
  public int getId() {
    
    return this.id;
  }
  
  
  public LoginResponse() {}
}