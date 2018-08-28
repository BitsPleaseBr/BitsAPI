package bits.api.cadastros.paciente;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import control.crypto.PswdStorage;
import model.bean.PacienteBean;
import model.bean.info.UserInfo;
import model.dao.PacienteDao;

public class CadPacHandler implements RequestHandler<CadPacRequest, CadPacResponse> {

    @Override
    public CadPacResponse handleRequest(CadPacRequest input, Context context) {

        PacienteBean pb = new PacienteBean();
        
        pb.setInfo(UserInfo.Nome, input.getNome());
        pb.setInfo(UserInfo.Sobrenome, input.getSobrenome());
        pb.setInfo(UserInfo.CPF, input.getCpf());
        pb.setInfo(UserInfo.DataNascimento, input.getDataNascimento());
        pb.setInfo(UserInfo.Email, input.getEmail());
        pb.setInfo(UserInfo.Senha, PswdStorage.clientPswdHash(input.getSenha(), input.getEmail()));
        
        int id = new PacienteDao().cadastrar(pb);
        
        CadPacResponse response = new CadPacResponse();
     
        response.setId(id);
        response.setSucesso(id == -1 ? false : true);
        
        return response;
    }
}