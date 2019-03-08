package controller;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.Headers;
import entity.Cinema;
import entity.Ticket;
import entity.User;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import security.JwtValidator;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

public abstract class HandlerByToken implements HttpHandler {

    public void handle(HttpExchange he) throws IOException {
        Headers header = he.getRequestHeaders();
        String method = he.getRequestMethod();
        URI uri = he.getRequestURI();
        System.out.println("uri= " + uri.toString());

        String response = null;

        String token = getTokenHeaderParams(he);

        User user = validateToken(token);

        if ("POST".equals(method)) {
            try {
                response =  doProcessPost(getRequestBody(he),user);
            } catch (Exception e) {
                System.err.println("err");
            }
        }
        sendResp(he, response);

    }

    public abstract String doProcessPost(JSONObject params, User user);

    private JSONObject getRequestBody(HttpExchange arg0) throws IOException, ParseException, org.json.simple.parser.ParseException {
        InputStream ins = arg0.getRequestBody();

        ByteArrayOutputStream result = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length;
        while ((length = ins.read(buffer)) != -1) {
            result.write(buffer, 0, length);
        }
        String data = result.toString("UTF-8");
        if (data == null || data.isEmpty()) {
            return null;
        }
        JSONParser parser = new JSONParser();
        JSONObject obj = (JSONObject) parser.parse(data);

        return obj;
    }

    private void sendResp(HttpExchange http, String resp) throws IOException {
        if (http == null) {
            return;
        }
        http.sendResponseHeaders(200, resp.getBytes("UTF-8").length);
        try (OutputStream os = http.getResponseBody()) {
            os.write(resp.getBytes("UTF-8"));
        }
    }

    protected User validateToken(String token){
        User user = JwtValidator.getInstance().validate(token);
        return user;
    }

    protected String getTokenHeaderParams(HttpExchange headerEx){
        String token = null;
        Headers requestHeaders = headerEx.getRequestHeaders();
        for(Map.Entry<String, List<String>> header : requestHeaders.entrySet()){
            String key = header.getKey();
            List<String> value = header.getValue();

            if(key.equals("Token")){
                token = value.get(0);
            }
        }
        return token;
    }
}
