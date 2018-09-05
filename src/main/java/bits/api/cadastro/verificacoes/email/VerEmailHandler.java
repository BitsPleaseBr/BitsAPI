package bits.api.cadastro.verificacoes.email;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import bits.api.Handler;
import model.bean.info.Tabela;
import model.bean.info.UserInfo;
import model.dao.StatementFactory;

public class VerEmailHandler extends Handler implements RequestHandler<VerEmailRequest, VerEmailResponse> {

  @Override
  public VerEmailResponse handleRequest(VerEmailRequest input, Context context) {

    setContext(context);
    
    VerEmailResponse response = new VerEmailResponse();
    
    String email = input.getEmail();

    StatementFactory sf = new StatementFactory();

    try {
      
      log("Executando statement para comunicação com banco de dados...");
      
      ResultSet rs = sf.setTabela(Tabela.User).setTipo(sf.SELECT).setInfos(UserInfo.ID).setCondition(UserInfo.Email).setConditionValue(email).create().executeQuery();
      
      boolean valido = !rs.next();
      
      response.setValido(valido);
    } catch (SQLException e) {
      
      response.setSucesso(false);
      response.addMessage("Falha", System.getenv("SQLException"));
      
      log(System.getenv("SQLException") + ": " + e.getMessage());
      
      return response;
    }
    
    response.setSucesso(true);
    
    log("A função foi executada com sucesso!");
    
    return response;
  }
}
