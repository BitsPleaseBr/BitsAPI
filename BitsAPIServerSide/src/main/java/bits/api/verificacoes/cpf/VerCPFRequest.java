package bits.api.verificacoes.cpf;

public class VerCPFRequest {

  
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