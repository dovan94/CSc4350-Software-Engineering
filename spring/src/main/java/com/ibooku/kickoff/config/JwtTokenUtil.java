package com.ibooku.kickoff.config;


import static com.ibooku.kickoff.model.SecurityConstants.HEADER_STRING;
import static com.ibooku.kickoff.model.SecurityConstants.SIGNING_KEY;
import static com.ibooku.kickoff.model.SecurityConstants.TOKEN_PREFIX;
import static com.ibooku.kickoff.model.SecurityConstants.VALIDITY_TIME;

import java.io.Serializable;
import java.util.Date;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.ibooku.kickoff.model.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil implements Serializable {
	
	public String getUsernameFromToken(String token) {
		return getClaimFromToken(token, Claims::getSubject);
	}
	
	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }
	
	// Jwts helps validate token 
	private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(SIGNING_KEY)
                .parseClaimsJws(token)
                .getBody();
    }
	
	public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }
	
	// check if token is expired
	private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }
	
	public String generateToken(User user) {
		return tokenGenerator(user.getUsername());
	}
	
	private String tokenGenerator(String username) {
		Claims claims = Jwts.claims().setSubject(username);
//		claims.put("scopes", value)
		return Jwts.builder()
				.setClaims(claims)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + VALIDITY_TIME))
				.signWith(SignatureAlgorithm.HS256, SIGNING_KEY)
				.compact();
	}
	
	public Boolean validateToken(String token, UserDetails userDetails) {
		final String username = getUsernameFromToken(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}
}

