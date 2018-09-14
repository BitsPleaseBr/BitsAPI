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

public class CadastroHandler extends Handler
    implements RequestHandler<CadastroRequest, CadastroResponse> {


  private final static String CADASTRO_MEDICO = System.getenv("CADASTRO_MEDICO"),
                              CADASTRO_PACIENTE = System.getenv("CADASTRO_PACIENTE"),
                              VERIFICACAO_CPF = System.getenv("VERIFICACAO_CPF"),
                              VERIFICACAO_EMAIL = System.getenv("VERIFICACAO_EMAIL");


  @Override
  public CadastroResponse handleRequest(CadastroRequest input, Context context) {

    setContext(context);

    Gson g = new Gson();
    String json = g.toJson(input.getValores());

    log("Redirecionando request...");

    String tipo = input.getTipo();
    
    if (tipo.equals(CADASTRO_MEDICO))
      return new CadMedHandler().handleRequest(g.fromJson(json, CadMedRequest.class), context);

    if (tipo.equals(CADASTRO_PACIENTE))
      return new CadPacHandler().handleRequest(g.fromJson(json, CadPacRequest.class), context);

    if (tipo.equals(VERIFICACAO_CPF))
      return new VerCPFHandler().handleRequest(g.fromJson(json, VerCPFRequest.class), context);

    if (tipo.equals(VERIFICACAO_EMAIL))
      return new VerEmailHandler().handleRequest(g.fromJson(json, VerEmailRequest.class),
          context);

    return null;
  }
}
