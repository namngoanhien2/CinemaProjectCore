package controller;


import entity.Cinema;
import entity.User;
import org.json.simple.JSONObject;
import security.JwtGenerator;
import Repo.RepoLogin;

public class LoginController extends HandlerNoUseToken {

    @Override
    public String doProcessPost(JSONObject params, Cinema cinema) {
        User usernhanvien = new User();
        RepoLogin serviceLogin = new RepoLogin();
        JSONObject js = new JSONObject();

        try {
            usernhanvien.setIduser(Integer.parseInt(params.get("iduser").toString()));
            usernhanvien.setUsername(params.get("username").toString());
            usernhanvien.setPassword(params.get("password").toString());
        } catch (Exception e) {
            js.put("rc", "-1");
            js.put("rd", e.toString());
            return js.toString();
        }
        String token = JwtGenerator.getInstance().generate(usernhanvien);
        //update
        serviceLogin.updateToken(token,usernhanvien.getIduser());

        if (!serviceLogin.login(usernhanvien).isEmpty()) {
            serviceLogin.ckeck(usernhanvien);
            js.put("rc", "1");
            js.put("rd", "Login success");
            js.put("token", token);
        } else {
            js.put("rc", "-1");
            js.put("rd", "Err");
        }
        return js.toString();
    }


}
