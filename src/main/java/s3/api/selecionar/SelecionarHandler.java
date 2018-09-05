package s3.api.selecionar;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;
import s3.api.Handler;
import s3.api.selecionar.selecoes.login.LoginHandler;
import s3.api.selecionar.selecoes.login.LoginRequest;
import s3.api.selecionar.selecoes.medico.SelMedHandler;
import s3.api.selecionar.selecoes.medico.SelMedRequest;
import s3.api.selecionar.selecoes.paciente.SelPacHandler;
import s3.api.selecionar.selecoes.paciente.SelPacRequest;

public class SelecionarHandler extends Handler
    implements RequestHandler<SelecionarRequest, SelecionarResponse> {


  private final static int SELECIONAR_PACIENTE = 1, SELECIONAR_MEDICO = 2, SELECIONAR_LOGIN = 3;


  @Override
  public SelecionarResponse handleRequest(SelecionarRequest input, Context context) {

    setContext(context);

    SelecionarResponse response = new SelecionarResponse();

    Gson g = new Gson();
    String json = g.toJson(input.getValores());

    switch (input.getTipo()) {

      case SELECIONAR_MEDICO:    return new SelMedHandler()
                                   .handleRequest(g.fromJson(json, SelMedRequest.class), context);

      case SELECIONAR_PACIENTE:  return new SelPacHandler()
                                   .handleRequest(g.fromJson(json, SelPacRequest.class), context);

      case SELECIONAR_LOGIN:     return new LoginHandler()
                                   .handleRequest(g.fromJson(json, LoginRequest.class), context);
    }

    response.setSucesso(true);

    log("A função foi executada com sucesso!");

    return response;
  }
}
