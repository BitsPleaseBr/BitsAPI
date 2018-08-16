package control.handler_stuff;

import java.util.HashMap;
import java.util.Map.Entry;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.bean.Bean;
import model.bean.EnderecoBean;
import model.bean.MedicoBean;
import model.bean.TelefoneBean;
import model.bean.info.Info;
import model.dao.MedicoDao;

public class Handler {

  
  @SuppressWarnings("unchecked")
  public static void main(String[] args) {
    
    MedicoBean bean = new MedicoDao().selecionar(10);
    
    String json = new GsonBuilder().setPrettyPrinting().create().toJson(bean);
    
    MedicoBean mb = new MedicoBean();
    
    
    HashMap<String, Object> infos = jsonToHash(json, String.class, Object.class);
    
    
    for (Entry<String, Object> info : infos.entrySet()) {
      
      Object value = info.getValue();
      
      if (value.toString().charAt(0) == '{') {
        
        HashMap<String, Object> maisInfos = jsonToHash(value.toString(), String.class, Object.class);
        
        for (Entry<String, Object> maisInfo : maisInfos.entrySet()) {
          
          System.out.println(maisInfo.getKey() + " - " + maisInfo.getValue());
        }
      }
    }
    
    
    /*for (Entry<Info, Object> entrada : mb.getInfos().entrySet()) {
      
      System.out.println(entrada.getKey() + " - " + entrada.getValue());
    }
    
    for (EnderecoBean eb : mb.getEnderecos()) {
      
      System.out.println(eb.toString());
    }
    
    for (TelefoneBean tb : mb.getTelefones()) {
      
      System.out.println(tb.toString());
    }*/
  }
  
  @SuppressWarnings("unchecked")
  private static <E, T> HashMap<E, T> jsonToHash(String json, Class<E> classeKey, Class<T> classeValue) {
    
    return (HashMap<E, T>) new Gson().fromJson(json, HashMap.class);
  }
  
  private Bean jsonToBean(String json, Class<? extends Bean> beanClasse) throws InstantiationException, IllegalAccessException {
    
     Bean bean = beanClasse.newInstance();
     
     
     
     return bean;
  }
}