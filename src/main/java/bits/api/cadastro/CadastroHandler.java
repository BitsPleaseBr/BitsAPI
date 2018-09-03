package bits.api.cadastro;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;
import bits.api.cadastro.cadastros.medico.CadMedHandler;
import bits.api.cadastro.cadastros.medico.CadMedRequest;
import bits.api.cadastro.cadastros.paciente.CadPacHandler;
import bits.api.cadastro.cadastros.paciente.CadPacRequest;
import bits.api.cadastro.verificacoes.cpf.VerCPFHandler;
import bits.api.cadastro.verificacoes.cpf.VerCPFRequest;
import bits.api.cadastro.verificacoes.email.VerEmailHandler;
import bits.api.cadastro.verificacoes.email.VerEmailRequest;
import bits.api.cadastro.verificacoes.login.LoginHandler;
import bits.api.cadastro.verificacoes.login.LoginRequest;

public class CadastroHandler implements RequestHandler<CadastroRequest, CadastroResponse> {

  
  private final static int CADASTRO_MEDICO = 1, CADASTRO_PACIENTE = 2, VERIFICACAO_CPF = 3, VERIFICACAO_EMAIL = 4, VERIFICACAO_LOGIN = 5;
  
  
  @Override
  public CadastroResponse handleRequest(CadastroRequest input, Context context) {
    
    Gson g = new Gson();
    String json = g.toJson(input.getValores());
    
    switch (input.getTipo()) {
      
      case CADASTRO_MEDICO:   return new CadMedHandler()
                                .handleRequest(g.fromJson(json, CadMedRequest.class), context);
      
      case CADASTRO_PACIENTE: return new CadPacHandler()
                                .handleRequest(g.fromJson(json, CadPacRequest.class), context);
      
      case VERIFICACAO_CPF:   return new VerCPFHandler()
                                .handleRequest(g.fromJson(json, VerCPFRequest.class), context);
      
      case VERIFICACAO_EMAIL: return new VerEmailHandler()
                                .handleRequest(g.fromJson(json, VerEmailRequest.class), context);
      
      case VERIFICACAO_LOGIN: return new LoginHandler()
                                .handleRequest(g.fromJson(json, LoginRequest.class), context);
    }

    return null;
  }
}