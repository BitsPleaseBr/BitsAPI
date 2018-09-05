package bits.api.selecionar.selecoes.login;

import java.sql.SQLException;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import bits.api.Handler;
import bits.api.selecionar.SelecionarResponse;
import model.dao.UserDao;

public class LoginHandler extends Handler implements RequestHandler<LoginRequest, SelecionarResponse> {

  @Override
  public SelecionarResponse handleRequest(LoginRequest input, Context context) {

    setContext(context);
    
    LoginResponse response = new LoginResponse();
    
    String email = input.getEmail();
    String senha = input.getSenha();
    
    int id = -1;
    try {
      
      log("Executando statement de comunicação com banco de dados...");
      
      id = new UserDao() {}.login(email, senha);
    } catch (SQLException e) {
      
      response.setSucesso(false);
      response.addMessage("Falha", System.getenv("SQLException"));
      
      log(System.getenv("SQLException") + ": " + e.getMessage());
      
      return response;
    }
    
    response.setId(id);
    response.setSucesso(true);
    
    log("A função foi executada com sucesso!");
    
    return response;
  }

}
