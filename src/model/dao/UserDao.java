package model.dao;

import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import control.crypto.PswdStorage;
import model.bean.EnderecoBean;
import model.bean.TelefoneBean;
import model.bean.UserBean;
import model.bean.info.EnderecoInfo;
import model.bean.info.Info;
import model.bean.info.Tabela;
import model.bean.info.TelefoneInfo;
import model.bean.info.UserInfo;

public abstract class UserDao extends Dao {


  protected int cadastrar(UserBean bean) {

    PreparedStatement ps = mapToInsertStatement(Tabela.User, bean.getInfosUser());

    try {
      ps.executeUpdate();
    } catch (SQLException e) {

      System.out.println("Erro ao cadastrar usuário \n" + bean.toString());
      e.printStackTrace();
    }

    try {
      ResultSet rs = ps.getGeneratedKeys();

      if (rs.next())
        return rs.getInt(1);
    } catch (SQLException e) {

      System.out.println("Erro ao obter id do usuário cadastrado \n" + bean.toString());
      e.printStackTrace();
    }

    return -1;
  }

  protected UserDao alterar(UserBean bean) {

    try {

      mapToUpdateStatement(Tabela.User, bean.getInfosUser(), UserInfo.ID).execute();
    } catch (SQLException e) {

      System.out.println("Não foi possível alterar o usuário com id " + bean.getInfo(UserInfo.ID));
      e.printStackTrace();
    }

    return this;
  }

  protected UserBean selecionar(int id) {

    return selecionar(UserInfo.ID, id);
  }

  protected UserBean selecionar(Info condition, Object conditionValue) {

    try {

      ResultSet[] rss = executeQuerys(condition, conditionValue);

      ResultSet rsUser = rss[0];
      ResultSet rsEnd = rss[1];
      ResultSet rsTel = rss[2];

      while (rsUser.next()) {
        
        return montarBean(rsUser, rsEnd, rsTel);
      }
    } catch (SQLException e) {

      System.out.println("Não foi possível selecionar o usuário usando a condição " + condition
          + " com o valor " + conditionValue);
      e.printStackTrace();
    }

    return null;
  }

  public int login(String email, String senha) {

    try {

      StatementFactory sf = new StatementFactory();

      ResultSet rs =
          sf.setTabela(Tabela.User).setTipo(sf.SELECT).setInfos(UserInfo.ID, UserInfo.Senha)
              .setCondition(UserInfo.Email).setConditionValue(email).create().executeQuery();

      while (rs.next()) {

        Blob senhaServer = rs.getBlob(2);
        int length = (int) senhaServer.length();

        if (PswdStorage.compararHashClient(senha, senhaServer.getBytes(1, length)))
          return rs.getInt(1);
      }

    } catch (SQLException e) {

      e.printStackTrace();
      return -2;
    }

    return -1;
  }


  private ResultSet[] executeQuerys(Info condition, Object conditionValue) {

    ResultSet[] rss = new ResultSet[3];

    try {

      rss[0] = infoToSelectStatement(Tabela.User, condition, conditionValue, UserInfo.values())
          .executeQuery();

      int id = 0;

      if (rss[0].next()) {
        
        id = rss[0].getInt("id");
        rss[0].beforeFirst();
      }
      
      rss[1] =
          infoToSelectStatement(Tabela.Endereco, EnderecoInfo.IDUser, id, EnderecoInfo.values())
              .executeQuery();
      rss[2] =
          infoToSelectStatement(Tabela.Telefone, TelefoneInfo.IDUser, id, TelefoneInfo.values())
              .executeQuery();
    } catch (SQLException e) {

      e.printStackTrace();
    }

    return rss;
  }


  private UserBean montarBean(ResultSet rsUser, ResultSet rsEnd, ResultSet rsTel) {

    UserBean bean = new UserBean();

    getUserInfo(bean, rsUser);
    getEndInfo(bean, rsEnd);
    getTelInfo(bean, rsTel);

    return bean;
  }

  private void getUserInfo(UserBean bean, ResultSet rs) {

    try {

      ResultSetMetaData rsmd = rs.getMetaData();

      for (int i = 1; i <= rsmd.getColumnCount(); i++) {

        String colName = rsmd.getColumnName(i);

        for (UserInfo info : UserInfo.values()) {

          if (info.getCampo().equals(colName)) {

            if (info.equals(UserInfo.DataNascimento)) {

              bean.setInfo(info, rs.getString(i));
            } else {
              
              bean.setInfo(info, rs.getObject(i));
            }
            break;
          }
        }
      }
    } catch (SQLException e) {

      e.printStackTrace();
    }
  }

  private void getEndInfo(UserBean bean, ResultSet rs) {

    try {

      EnderecoBean endBean = null;
      
      while (rs.next()) {

        endBean = new EnderecoBean();
        
        ResultSetMetaData rsmd = rs.getMetaData();

        for (int i = 1; i <= rsmd.getColumnCount(); i++) {

          String colName = rsmd.getColumnName(i);

          for (EnderecoInfo info : EnderecoInfo.values()) {

            if (info.getCampo().equals(colName)) {

              endBean.setInfo(info, rs.getObject(i));
              break;
            }
          }
        }

        bean.addEndereco(endBean);
      }

    } catch (SQLException e) {

      e.printStackTrace();
    }
  }

  private void getTelInfo(UserBean bean, ResultSet rs) {

    try {

      TelefoneBean telBean = null;
      
      while (rs.next()) {

        telBean = new TelefoneBean();
        
        ResultSetMetaData rsmd = rs.getMetaData();

        for (int i = 1; i <= rsmd.getColumnCount(); i++) {

          String colName = rsmd.getColumnName(i);

          for (TelefoneInfo info : TelefoneInfo.values()) {

            if (info.getCampo().equals(colName)) {

              telBean.setInfo(info, rs.getObject(i));
              break;
            }
          }
        }
        
        bean.addTelefone(telBean);
      }

    } catch (SQLException e) {

      e.printStackTrace();
    }
  }
}
