package bits.api.verificacoes.cpf;

import bits.api.Response;

public class VerCPFResponse extends Response {

  
  private boolean valido;
  
  
  public VerCPFResponse(boolean sucesso, boolean valido) {
    
    this.sucesso = sucesso;
    this.valido = valido;
  }
  
  
  public void setValido(boolean valido) {
    
    this.valido = valido;
  }
  
  public boolean getValido() {
    
    return this.valido;
  }
  
  public VerCPFResponse() {}
}