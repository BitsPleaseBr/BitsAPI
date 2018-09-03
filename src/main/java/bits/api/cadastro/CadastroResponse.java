package bits.api.cadastro;

import bits.api.Response;

public class CadastroResponse extends Response {

  
  private String lambdaInvocada;
  
  
  public void setLambdaInvocada(String nome) {
    
    this.lambdaInvocada = nome;
  }
  
  public String getLambdaInvocada() {
    
    return this.lambdaInvocada;
  }
}