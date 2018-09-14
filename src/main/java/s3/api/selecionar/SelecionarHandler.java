package s3.api.selecionar;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;
import s3.api.Handler;
import s3.api.selecionar.selecoes.medico.SelMedHandler;
import s3.api.selecionar.selecoes.medico.SelMedRequest;
import s3.api.selecionar.selecoes.paciente.SelPacHandler;
import s3.api.selecionar.selecoes.paciente.SelPacRequest;

public class SelecionarHandler extends Handler
    implements RequestHandler<SelecionarRequest, SelecionarResponse> {


  private final static String SELECIONAR_PACIENTE = System.getenv("SELECIONAR_PACIENTE"),
                              SELECIONAR_MEDICO   = System.getenv("SELECIONAR_MEDICO");


  @Override
  public SelecionarResponse handleRequest(SelecionarRequest input, Context context) {

    setContext(context);

    SelecionarResponse response = new SelecionarResponse();

    Gson g = new Gson();
    String json = g.toJson(input.getValores());

    String tipo = input.getTipo();
    
    if (tipo.equals(SELECIONAR_MEDICO))
      return new SelMedHandler().handleRequest(g.fromJson(json, SelMedRequest.class), context);

    if (tipo.equals(SELECIONAR_PACIENTE))
      return new SelPacHandler().handleRequest(g.fromJson(json, SelPacRequest.class), context);

    response.setSucesso(true);

    log("A função foi executada com sucesso!");

    return response;
  }
}