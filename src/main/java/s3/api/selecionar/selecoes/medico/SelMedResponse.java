package s3.api.selecionar.selecoes.medico;

import s3.api.selecionar.SelecionarResponse;

public class SelMedResponse extends SelecionarResponse {

  
  public SelMedResponse() {
    
    setLambdaInvocada("Lambda para obtenção de dados do médico");
  }
}