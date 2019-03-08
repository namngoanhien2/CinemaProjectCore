package controller;

import Service.CinemaaRegisterService;
import entity.Cinema;
import org.json.simple.JSONObject;

public class RegisterController extends HandlerNoUseToken {
    @Override
    public String doProcessPost(JSONObject params, Cinema cinema) {
        CinemaaRegisterService cinemaaRegisterService = new CinemaaRegisterService();
        int paramId = Integer.parseInt(params.get("iduser").toString());
        String paramName = params.get("username").toString();
        String paramPassword = params.get("password").toString();
        int paramrole = Integer.parseInt(params.get("role").toString());
        String ListRegister = cinemaaRegisterService.Register(paramId,paramName,paramPassword,paramrole);
        return ListRegister;
    }
}
