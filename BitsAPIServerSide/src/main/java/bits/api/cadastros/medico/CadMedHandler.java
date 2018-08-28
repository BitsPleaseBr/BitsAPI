package bits.api.cadastros.medico;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import control.crypto.PswdStorage;
import model.bean.EnderecoBean;
import model.bean.MedicoBean;
import model.bean.TelefoneBean;
import model.bean.info.EnderecoInfo;
import model.bean.info.MedicoInfo;
import model.bean.info.TelefoneInfo;
import model.bean.info.UserInfo;
import model.dao.MedicoDao;

public class CadMedHandler implements RequestHandler<CadMedRequest, CadMedResponse> {

  @Override
  public CadMedResponse handleRequest(CadMedRequest input, Context context) {

    MedicoBean mb = new MedicoBean();

    // Informações do médico
    mb.setInfo(UserInfo.Nome, input.getNome());
    mb.setInfo(UserInfo.Sobrenome, input.getSobrenome());
    mb.setInfo(UserInfo.CPF, input.getCpf());
    mb.setInfo(UserInfo.DataNascimento, input.getDataNascimento());
    mb.setInfo(UserInfo.Email, input.getEmail());
    mb.setInfo(UserInfo.Senha, PswdStorage.clientPswdHash(input.getSenha(), input.getEmail()));

    mb.setInfo(MedicoInfo.CRM, input.getCrm());
    mb.setInfo(MedicoInfo.UF, input.getUf());
    mb.setInfo(MedicoInfo.Pais, input.getPais());

    // Telefone
    TelefoneBean tt = new TelefoneBean();

    tt.setInfo(TelefoneInfo.Tipo, tt.TELEFONE);
    tt.setInfo(TelefoneInfo.Numero, input.getTelefone());

    // Celular
    TelefoneBean tc = new TelefoneBean();

    tc.setInfo(TelefoneInfo.Tipo, tc.CELULAR);
    tc.setInfo(TelefoneInfo.Numero, input.getCelular());

    // Endereço Residencial
    EnderecoBean er = new EnderecoBean();

    er.setInfo(EnderecoInfo.Tipo, er.RESIDENCIAL);
    er.setInfo(EnderecoInfo.Cep, input.getCepResidencial());
    er.setInfo(EnderecoInfo.Estado, input.getUf());
    er.setInfo(EnderecoInfo.Cidade, input.getCidadeResidencial());
    er.setInfo(EnderecoInfo.Bairro, input.getBairroResidencial());
    er.setInfo(EnderecoInfo.Rua, input.getRuaResidencial());
    er.setInfo(EnderecoInfo.Numero, input.getNumeroResidencial());
    er.setInfo(EnderecoInfo.Complemento, input.getComplementoResidencial());

    // Endereço Comercial
    EnderecoBean ec = new EnderecoBean();

    ec.setInfo(EnderecoInfo.Tipo, er.COMERCIAL);
    ec.setInfo(EnderecoInfo.Cep, input.getCepComercial());
    ec.setInfo(EnderecoInfo.Estado, input.getUf());
    ec.setInfo(EnderecoInfo.Cidade, input.getCidadeComercial());
    ec.setInfo(EnderecoInfo.Bairro, input.getBairroComercial());
    ec.setInfo(EnderecoInfo.Rua, input.getRuaComercial());
    ec.setInfo(EnderecoInfo.Numero, input.getNumeroComercial());
    ec.setInfo(EnderecoInfo.Complemento, input.getComplementoComercial());

    //Adicionando adicionais ao Bean
    mb.addTelefone(tt);
    mb.addTelefone(tc);
    mb.addEndereco(er);
    mb.addEndereco(ec);
    
    //Cadastrando
    int id = new MedicoDao().cadastrar(mb);
    
    //Fazendo resposta
    CadMedResponse response = new CadMedResponse();
    
    response.setId(id);
    response.setSucesso(id == -1 ? false : true);
    
    return response;
  }
}
