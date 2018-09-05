package bits.api.selecionar;

import bits.api.Response;
import model.bean.UserBean;

public class SelecionarResponse extends Response {

  
  private UserBean bean;
  
  
  public void setBean(UserBean bean) {
    
    this.bean = bean;
  }
  
  public UserBean getBean() {
    
    return this.bean;
  }
}