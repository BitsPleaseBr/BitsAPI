package bits.api.verificacoes.cpf;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import model.bean.info.Tabela;
import model.bean.info.UserInfo;
import model.dao.StatementFactory;

public class VerCPFHandler implements RequestHandler<VerCPFRequest, VerCPFResponse> {

  @Override
  public VerCPFResponse handleRequest(VerCPFRequest input, Context context) {

    VerCPFResponse response = new VerCPFResponse();
    
    String cpf = input.getCPF();

    StatementFactory sf = new StatementFactory();
    ResultSet rs;
    try {
      rs = sf.setTabela(Tabela.User).setTipo(sf.SELECT).setInfos(UserInfo.Situacao).setCondition(UserInfo.CPF).setConditionValue(cpf).create().executeQuery();
   
      boolean valido = true;
      
      if (rs.next()) {
        if (rs.getInt(1) > 3) {
          valido = false;
        }
      }
      
      response.setValido(valido);  
    } catch (SQLException e) {
      
      response.setSucesso(false);
      response.addMessage("Falha", "Erro ao comunicar com banco de dados");
      
      context.getLogger().log("Falha ao comunicar com banco de dados: " + e.getMessage());
      
      return response;
    }
    
    response.setSucesso(true);
    
    return response;
  }
}
