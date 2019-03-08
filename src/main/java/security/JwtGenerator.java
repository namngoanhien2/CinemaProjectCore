package security;

import entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtGenerator {

    private JwtGenerator() {
    }

    private static class BillPughSingleton{
        private static final JwtGenerator INSTANCE = new JwtGenerator();
    }

    public static JwtGenerator getInstance(){
        return BillPughSingleton.INSTANCE;
    }

    public String generate(User usernhanvien) {
        Claims claims = Jwts.claims()
                .setSubject(usernhanvien.getUsername());
        claims.put("iduser", usernhanvien.getIduser());
        claims.put("username", usernhanvien.getUsername());
        claims.put("password", usernhanvien.getPassword());
        Date date = new Date();
        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS256, "SECRET")
                .setIssuedAt(date)
                .setExpiration(new Date(date.getTime() + 10000 * 60))
                .compact();
    }

}
