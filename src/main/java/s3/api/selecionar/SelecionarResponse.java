package s3.api.selecionar;

import model.bean.UserBean;
import s3.api.Response;

public class SelecionarResponse extends Response {

  
  private UserBean bean;
  
  
  public void setBean(UserBean bean) {
    
    this.bean = bean;
  }
  
  public UserBean getBean() {
    
    return this.bean;
  }
}