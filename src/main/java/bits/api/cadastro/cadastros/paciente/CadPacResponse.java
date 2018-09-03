package bits.api.cadastro.cadastros.paciente;

import bits.api.cadastro.cadastros.CadResponse;

public class CadPacResponse extends CadResponse {


  public CadPacResponse(boolean sucesso, int id) {

    super(sucesso, id);

    setLambdaInvocada("Lambda para Cadastro de Pacientes");
  }


  public CadPacResponse() {
    
    setLambdaInvocada("Lambda para Cadastro de Pacientes");
  }
}
