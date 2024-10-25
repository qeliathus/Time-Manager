package by.potapchuk.TimeTracker.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {

    private final String SECRET_KEY = "845d3147b9e1888420555ff668dfed162c80d381e7fd7423716a31e0162cedebb7117cc8b7209df336fad860157c0ee94146de9baf5fbf43fd973b366f3e332991167362a232ee559415fa4d439bb9f8651b49a69ee9d7eae83387abee0fc0a2ed9523e5333762ae0e5eeff1f0b52fe63567fa532dadf1d998956aa8ba351767211e260d4157157f42c6a797a5bf61c56816ebe6401edb4e6f0a154495ce06e795648f236eeb751b7fba0d9f3eb8cdac64cb817e63cc4320f43562e2857c7d18969c778c963046eef638b5129b71243541ff0b1aaeae39bd8cc0c3c7d95cfb40bf4cd7ff0d11bbd3df872996be9ceffd904ffcd9c1a3e18526df12085e04da88";
    private final long EXPIRATION_TIME = 1000 * 60 * 60;

    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, username);
    }

    private String createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public String extractUsername(String token) {
        return extractAllClaims(token).getSubject();
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }

    public boolean validateToken(String token, String username) {
        final String extractedUsername = extractUsername(token);
        return (extractedUsername.equals(username) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return extractAllClaims(token).getExpiration().before(new Date());
    }
}