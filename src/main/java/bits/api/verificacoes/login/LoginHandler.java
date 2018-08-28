package bits.api.verificacoes.login;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import model.dao.UserDao;

public class LoginHandler implements RequestHandler<LoginRequest, LoginResponse> {

  @Override
  public LoginResponse handleRequest(LoginRequest input, Context context) {

    String email = input.getEmail();
    String senha = input.getSenha();
    
    return new LoginResponse(true, new UserDao() {}.login(email, senha));
  }

}
