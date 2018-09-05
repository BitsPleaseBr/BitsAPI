package s3.api.selecionar.selecoes.medico;

import java.sql.SQLException;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import model.bean.MedicoBean;
import model.dao.MedicoDao;
import s3.api.Handler;

public class SelMedHandler extends Handler implements RequestHandler<SelMedRequest, SelMedResponse> {

  @Override
  public SelMedResponse handleRequest(SelMedRequest input, Context context) {

    setContext(context);
    
    SelMedResponse response = new SelMedResponse();
    MedicoBean ub = null;
    
    try {

      log("Obtendo dados do médico...");

      ub = new MedicoDao().selecionar(input.getId());

      log(ub == null ? "Médico não encontrado!": "Dados obtidos com sucesso!");
    } catch (SQLException e) {

      response.setSucesso(false);
      response.addMessage("Falha", System.getenv("SQLException"));

      log(System.getenv("SQLException") + ": " + e.getMessage());

      return response;
    }

    response.setSucesso(true);
    response.setBean(ub);

    log("A função foi executada com sucesso!");

    return response;
  }

}
