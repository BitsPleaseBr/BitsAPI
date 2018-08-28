package bits.api.verificacoes.cpf;

public class VerCPFResponse {

  
  private boolean valido;
  private boolean  sucesso;
  
  
  public VerCPFResponse(boolean sucesso, boolean valido) {
    
    this.valido = valido;
  }
  
  
  public void setValido(boolean valido) {
    
    this.valido = valido;
  }
  
  public boolean getValido() {
    
    return this.valido;
  }
  
  public void setSucesso(boolean sucesso) {
    
    this.sucesso = sucesso;
  }
  
  public boolean getSucesso() {
    
    return this.sucesso;
  }
  
  public VerCPFResponse() {}
}