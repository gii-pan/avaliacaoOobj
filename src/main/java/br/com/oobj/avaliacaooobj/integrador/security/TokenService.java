package br.com.oobj.avaliacaooobj.integrador.security;

import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    @Value("${avaliacaoOobj.jwt.secret}")
    private String secret;

    public boolean isTokenValido(String token) {
        try {
            Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
            return true;

        } catch (Exception e) {
            return false;
        }
    }
}
