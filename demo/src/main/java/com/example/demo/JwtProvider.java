package com.example.demo;

import com.example.demo.entity.AccessToken;

import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Jwts;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtProvider {
    public AccessToken createAccessToken(Authentication authentication, boolean rememberMe, boolean isAdminApi) {
        UserPrincipal principal = (UserPrincipal) authentication.getPrincipal();
        String name = String.valueOf(principal.getUserId());
        long now = (new Date()).getTime();
        long dateToMilliseconds = 24*60*60*1000;
        Date validity;

        //Build access token
        String jwt = Jwts.builder().setSubject(name)
                .setClaims(buildClaims(principal, isAdminApi))
                .signWith(SignatureAlgorithm.HS512, "demo.token").compact();

        AccessToken accessToken = new AccessToken();
        accessToken.setToken(jwt);
        accessToken.setUserId(principal.getUserId());
        accessToken.setTokenType("Bearer");
        return accessToken;
    }

    private Map<String, Object> buildClaims(UserPrincipal principal, boolean isAdminApi) {
        Map<String, Object> claims = new HashMap<String, Object>();
        claims.put("userId", principal.getUserId());
        claims.put("tfaChecked", principal.isTfaChecked());
        claims.put("isAdminApi", isAdminApi);
        return claims;
    }

}
