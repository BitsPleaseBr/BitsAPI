package bits.api.cadastro.verificacoes.email;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import model.bean.info.Tabela;
import model.bean.info.UserInfo;
import model.dao.StatementFactory;

public class VerEmailHandler implements RequestHandler<VerEmailRequest, VerEmailResponse> {

  @Override
  public VerEmailResponse handleRequest(VerEmailRequest input, Context context) {

    VerEmailResponse response = new VerEmailResponse();
    
    String email = input.getEmail();

    StatementFactory sf = new StatementFactory();

    try {
      
      ResultSet rs = sf.setTabela(Tabela.User).setTipo(sf.SELECT).setInfos(UserInfo.ID).setCondition(UserInfo.Email).setConditionValue(email).create().executeQuery();
      
      boolean valido = !rs.next();
      
      response.setValido(valido);
    } catch (SQLException e) {
      
      response.setSucesso(false);
      response.addMessage("Falha", "Erro ao comunicar com banco de dados");
      
      context.getLogger().log("Erro ao conectar com banco de dados: " + e.getMessage());
      
      return response;
    }
    
    response.setSucesso(true);
    
    return response;
  }
}
