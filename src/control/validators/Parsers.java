package control.validators;

public class Parsers {
  
  public static String removeNonNum(String str) {
    return str.replaceAll("\\D", "");
  }
  
  public static String removeNonNum(Object str) {
    return removeNonNum(str.toString());
  }
  
  public static String cepParse(Object CEP) {
    String str = removeNonNum(CEP);
    return str.length()==11? str:null;
  }
  
  public static String cpfParse(Object CPF) {
    String str = removeNonNum(CPF);
    return str.length()==11? str:null;
  }
}
