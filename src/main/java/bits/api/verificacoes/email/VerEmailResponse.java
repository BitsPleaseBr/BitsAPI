package bits.api.verificacoes.email;

import bits.api.Response;

public class VerEmailResponse extends Response {

  
  private boolean valido;
  
  
  public VerEmailResponse(boolean sucesso, boolean valido) {
    
    this.sucesso = sucesso;
    this.valido = valido;
  }
  
  
  public void setValido(boolean valido) {
    
    this.valido = valido;
  }
  
  public boolean getValido() {
    
    return this.valido;
  }
  
  
  public VerEmailResponse() {}
}