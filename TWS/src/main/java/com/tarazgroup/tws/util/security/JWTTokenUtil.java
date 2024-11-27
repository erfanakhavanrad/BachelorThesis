package com.tarazgroup.tws.util.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.DefaultClaims;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * @author alireza_bayat
 * @since 2.0.0
 */

@Component
public class JWTTokenUtil implements Serializable {

    @Value("${jwt.expirationDateInMs}")
    private long expirationDateInMs;

    @Value("${jwt.refreshExpirationDateInMs}")
    private long refreshExpirationDateInMs;

    private final static String secret = "M0$e$_'S_4T@ff_!$_Much_be7ter_th@n_h@rry_po77er_^s_waND";

    public String getUserIDFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    public Double getLoginIDFromToken(String token) {
        Jws<Claims> jwsMap = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token);
        return jwsMap.getBody().get("loginID", Double.class);
    }

    public String getUserNameFromToken(String token) {
        Jws<Claims> jwsMap = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token);
        return jwsMap.getBody().get("userName", String.class);
    }

    private static Claims getClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    private <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    private Boolean isTokenExpired(String token) {
        final Date expiration = getClaimFromToken(token, Claims::getExpiration);
        return expiration.before(new Date());
    }


    public String generateToken(BigDecimal userID, BigDecimal loginID, String userName) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("loginID", loginID);
        claims.put("userName", userName);
        return doGenerateToken(claims, userID);
    }

    private String doGenerateToken(Map<String, Object> claims, BigDecimal userID) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userID.toString())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expirationDateInMs))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public String doGenerateRefreshToken(DefaultClaims defaultClaims) {
        return Jwts.builder()
                .setClaims(defaultClaims)
                .setSubject(defaultClaims.getSubject())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + refreshExpirationDateInMs))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String userName = getUserNameFromToken(token);
        return (userName.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private static String removeBearerFromToken(String token) {
        return token.replaceAll("Bearer ", "");
    }

    public static String getPerComIdFromToken(HttpServletRequest request){
        return JWTTokenUtil.getClaimsFromToken(JWTTokenUtil.removeBearerFromToken(String.valueOf(request.getHeader("Authorization")))).get("sub", String.class);

    }
}
