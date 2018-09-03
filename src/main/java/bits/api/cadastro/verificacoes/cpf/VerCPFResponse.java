package bits.api.cadastro.verificacoes.cpf;

import bits.api.cadastro.CadastroResponse;

public class VerCPFResponse extends CadastroResponse {

  
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