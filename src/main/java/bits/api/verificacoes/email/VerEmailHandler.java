package bits.api.verificacoes.email;

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

    String email = input.getEmail();

    StatementFactory sf = new StatementFactory();

    try {
      
      ResultSet rs = sf.setTabela(Tabela.User).setTipo(sf.SELECT).setInfos(UserInfo.ID).setCondition(UserInfo.Email).setConditionValue(email).create().executeQuery();
      
      boolean valido = !rs.next();
      
      return new VerEmailResponse(true, valido);
    } catch (SQLException e) {
      
      
      e.printStackTrace();
      return new VerEmailResponse(false, false);
    }
  }
}
