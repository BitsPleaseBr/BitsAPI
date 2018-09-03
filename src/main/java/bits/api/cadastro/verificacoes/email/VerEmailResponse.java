package bits.api.cadastro.verificacoes.email;

import bits.api.cadastro.CadastroResponse;

public class VerEmailResponse extends CadastroResponse {

  
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