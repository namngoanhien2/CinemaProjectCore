package security;

import entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;

public class JwtValidator {
    static private JwtValidator instance;

    private JwtValidator() {

    }

    public static JwtValidator getInstance() {
        if (instance == null) {
            instance = new JwtValidator();
        }
        return instance;
    }

    public User validate(String token) {
        User usernhanvien= null;
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey("SECRET")
                    .parseClaimsJws(token)
                    .getBody();

            usernhanvien = new User();
            usernhanvien.setIduser(Integer.parseInt(claims.get("iduser").toString()));
            usernhanvien.setUsername(claims.get("username").toString());
            usernhanvien.setPassword(claims.get("password").toString());

            System.out.println(claims);
            System.out.println(usernhanvien);
        } catch (ExpiredJwtException ejwte) {
            System.err.println("Jwt Expired: " + ejwte);
        } catch (Exception e) {
            System.out.println(e);
        }
        return usernhanvien;
    }
}