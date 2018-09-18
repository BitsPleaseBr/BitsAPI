package s3.api.selecionar;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;
import s3.api.Handler;
import s3.api.selecionar.dados.medico.SelMedHandler;
import s3.api.selecionar.dados.medico.SelMedRequest;
import s3.api.selecionar.dados.paciente.SelPacHandler;
import s3.api.selecionar.dados.paciente.SelPacRequest;
import s3.api.selecionar.dados.usuario.SelUseHandler;
import s3.api.selecionar.dados.usuario.SelUseRequest;

public class SelecionarHandler extends Handler
    implements RequestHandler<SelecionarRequest, SelecionarResponse> {


  private final static String SELECIONAR_DADOS_PACIENTE = System.getenv("SELECIONAR_DADOS_PACIENTE"),
                              SELECIONAR_DADOS_MEDICO   = System.getenv("SELECIONAR_DADOS_MEDICO"),
                              SELECIONAR_DADOS_USUARIO  = System.getenv("SELECIONAR_DADOS_USUARIO");


  @Override
  public SelecionarResponse handleRequest(SelecionarRequest input, Context context) {

    setContext(context);

    SelecionarResponse response = new SelecionarResponse();

    Gson g = new Gson();
    String json = g.toJson(input.getValores());

    String tipo = input.getTipo();
    
    if (tipo.equals(SELECIONAR_DADOS_MEDICO))
      return new SelMedHandler().handleRequest(g.fromJson(json, SelMedRequest.class), context);

    if (tipo.equals(SELECIONAR_DADOS_PACIENTE))
      return new SelPacHandler().handleRequest(g.fromJson(json, SelPacRequest.class), context);

    if (tipo.equals(SELECIONAR_DADOS_USUARIO))
      return new SelUseHandler().handleRequest(g.fromJson(json, SelUseRequest.class), context);
    
    response.setSucesso(true);

    log("A função foi executada com sucesso!");

    return response;
  }
}