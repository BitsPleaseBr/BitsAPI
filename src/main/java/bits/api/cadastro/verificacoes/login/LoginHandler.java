package bits.api.cadastro.verificacoes.login;

import java.sql.SQLException;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import model.dao.UserDao;

public class LoginHandler implements RequestHandler<LoginRequest, LoginResponse> {

  @Override
  public LoginResponse handleRequest(LoginRequest input, Context context) {

    LoginResponse response = new LoginResponse();
    
    String email = input.getEmail();
    String senha = input.getSenha();
    
    int id = -1;
    try {
      
      id = new UserDao() {}.login(email, senha);
    } catch (SQLException e) {
      
      response.setSucesso(false);
      response.addMessage("Falha", "Erro ao comunicar com banco de dados");
      
      context.getLogger().log("Falha ao comunicar com banco de dados: " + e.getMessage());
      
      return response;
    }
    
    response.setId(id);
    response.setSucesso(true);
    
    return response;
  }

}
