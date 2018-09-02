package bits.api.verificacoes.email;

public class VerEmailResponse {

  
  private boolean sucesso;
  private boolean valido;
  
  
  public VerEmailResponse(boolean sucesso, boolean valido) {
    
    this.sucesso = sucesso;
    this.valido = valido;
  }
  
  
  public void setSucesso(boolean sucesso) {
    
    this.sucesso = sucesso;
  }
  
  public boolean getSucesso() {
    
    return this.sucesso;
  }
  
  
  public void setValido(boolean valido) {
    
    this.valido = valido;
  }
  
  public boolean getValido() {
    
    return this.valido;
  }
  
  
  public VerEmailResponse() {}
}