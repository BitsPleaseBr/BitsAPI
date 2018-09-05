package bits.api;

import java.util.HashMap;

public class Request {


  private int tipo;
  private HashMap<String, Object> valores;


  public void setTipo(int tipo) {

    this.tipo = tipo;
  }

  public int getTipo() {

    return this.tipo;
  }

  public HashMap<String, Object> getValores() {
    return valores;
  }

  public void setValores(HashMap<String, Object> valores) {
    this.valores = valores;
  }
}
