package com.smsimulator.server.security;

import com.smsimulator.core.Debugger;
import io.jsonwebtoken.*;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.Restlet;

import java.time.LocalDate;
import java.util.Date;

/**
 * Project UCD_FinalProject_SAVICK
 * Created by skaveesh on 2018-06-25.
 */
public class JWTSecurity extends Restlet {

    protected boolean tokenAccepted = false;

    @Override
    public void handle(Request request, Response response) {

        try {
            String authorizationHeader = request.getHeaders().getValues("Authorization");

            Jws<Claims> claims = Jwts.parser().setSigningKey(JWTKey.key).parseClaimsJws(authorizationHeader);

            if (claims.getBody().getSubject().equals("Auth")) {

                Debugger.log(claims.getBody().getAudience());
                Debugger.log(claims.getBody().getExpiration());
                tokenAccepted = true;

            } else
                tokenAccepted = false;
        } catch (Exception e) {
            tokenAccepted = false;
            Debugger.log("Authorization Failed");
        }

    }

    public String createJwt(String username) {

        Date today = java.sql.Date.valueOf(LocalDate.now());
        Date expireDate = java.sql.Date.valueOf(LocalDate.now().plusDays(2));

        return Jwts.builder().setSubject("Auth").setIssuedAt(today).setExpiration(expireDate).setAudience(username).signWith(SignatureAlgorithm.HS512, JWTKey.key).compact();
    }

    public String createJwtWithExistingJwt(String oldAuth) {

        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(JWTKey.key).parseClaimsJws(oldAuth);
            String username = claims.getBody().getAudience();
            Date issuedDate = claims.getBody().getIssuedAt();
            Date expireDate = java.sql.Date.valueOf(LocalDate.now().plusDays(2));

            return Jwts.builder().setSubject("Auth").setIssuedAt(issuedDate).setExpiration(expireDate).setAudience(username).signWith(SignatureAlgorithm.HS512, JWTKey.key).compact();
        } catch (Exception e) {
            Debugger.log("Authorization Failed");
            return null;
        }


    }

}