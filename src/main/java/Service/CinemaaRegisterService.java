package Service;

import Repo.RepoRegister;
import entity.User;
import org.json.simple.JSONObject;
import java.util.List;

public class CinemaaRegisterService {
    public String Register (int iduser, String username, String password, int role){
        RepoRegister reporegister = new RepoRegister();
        List<User> list = reporegister.Register(iduser,username,password,role);
        JSONObject js = new JSONObject();
        if(list.isEmpty()){
            js.put("rc", "-1");
            js.put("rd", "Err");
        }else {
            js.put("rc", "1");
            js.put("rd", "Register success");
        }
        return js.toString();
    }
}
