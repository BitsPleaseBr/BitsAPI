package s3.api.cadastro.verificacoes.email;

import s3.api.cadastro.CadastroResponse;

public class VerEmailResponse extends CadastroResponse {

  
  private boolean valido;
  
  
  public VerEmailResponse(boolean sucesso, boolean valido) {
    
    setLambdaInvocada("Lambda para Verificação de E-mail");
    this.sucesso = sucesso;
    this.valido = valido;
  }
  
  
  public void setValido(boolean valido) {
    
    this.valido = valido;
  }
  
  public boolean getValido() {
    
    return this.valido;
  }
  
  
  public VerEmailResponse() {
    
    setLambdaInvocada("Lambda para Verificação de E-mail");
  }
}