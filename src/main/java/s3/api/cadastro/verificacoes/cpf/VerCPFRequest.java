package s3.api.cadastro.verificacoes.cpf;

import s3.api.cadastro.CadastroRequest;

public class VerCPFRequest extends CadastroRequest {

  
  private String cpf;
  
  
  public VerCPFRequest(String cpf) {
    
    this.cpf = cpf;
  }
  
  
  public void setCPF(String cpf) {
    
    this.cpf = cpf;
  }
  
  public String getCPF() {
    
    return this.cpf;
  }
  
  
  public VerCPFRequest() {}
}