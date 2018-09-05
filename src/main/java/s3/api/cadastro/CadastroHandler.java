package s3.api.cadastro;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;
import s3.api.Handler;
import s3.api.cadastro.cadastros.medico.CadMedHandler;
import s3.api.cadastro.cadastros.medico.CadMedRequest;
import s3.api.cadastro.cadastros.paciente.CadPacHandler;
import s3.api.cadastro.cadastros.paciente.CadPacRequest;
import s3.api.cadastro.verificacoes.cpf.VerCPFHandler;
import s3.api.cadastro.verificacoes.cpf.VerCPFRequest;
import s3.api.cadastro.verificacoes.email.VerEmailHandler;
import s3.api.cadastro.verificacoes.email.VerEmailRequest;

public class CadastroHandler extends Handler implements RequestHandler<CadastroRequest, CadastroResponse> {

  
  private final static int CADASTRO_MEDICO = 1, CADASTRO_PACIENTE = 2, VERIFICACAO_CPF = 3, VERIFICACAO_EMAIL = 4;
  
  
  @Override
  public CadastroResponse handleRequest(CadastroRequest input, Context context) {
    
    setContext(context);
    
    Gson g = new Gson();
    String json = g.toJson(input.getValores());
    
    log("Redirecionando request...");
    
    switch (input.getTipo()) {
      
      case CADASTRO_MEDICO:   return new CadMedHandler()
                                .handleRequest(g.fromJson(json, CadMedRequest.class), context);
      
      case CADASTRO_PACIENTE: return new CadPacHandler()
                                .handleRequest(g.fromJson(json, CadPacRequest.class), context);
      
      case VERIFICACAO_CPF:   return new VerCPFHandler()
                                .handleRequest(g.fromJson(json, VerCPFRequest.class), context);
      
      case VERIFICACAO_EMAIL: return new VerEmailHandler()
                                .handleRequest(g.fromJson(json, VerEmailRequest.class), context);
    }

    return null;
  }
}