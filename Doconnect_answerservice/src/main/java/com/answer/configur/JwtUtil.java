package com.answer.configur;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.HttpServletRequest;
@Component
public class JwtUtil {


    public static final String SECRET = "DoConnectProject";
   
    	public String extractUsername(String token) {
    		return extractClaim(token, Claims::getSubject);
    	}

    	public Date extractExpiration(String token) {
    		return extractClaim(token, Claims::getExpiration);
    	}

    	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
    		final Claims claims = extractAllClaims(token);
    		return claimsResolver.apply(claims);
    	}

    	private Claims extractAllClaims(String token) {
    		return Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
    	}

    	private Boolean isTokenExpired(String token) {
    		return extractExpiration(token).before(new Date());
    	}

    	public String generateToken(String username) {
    		Map<String, Object> claims = new HashMap<>();
    		return createToken(claims, username);

    	}

    	private String createToken(Map<String, Object> claims, String subject) {

    		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
    				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
    				.signWith(SignatureAlgorithm.HS256, SECRET).compact();
    	}

//    	public String validateToken(String token, String userDetails) {
//    		final String username = extractUsername(token);
//    		return (username.equals(userDetails) && !isTokenExpired(token));
//    	}
    	public boolean validateToken(String token, String userDetails) {
    	    final String username = extractUsername(token);
    	    return username.equals(userDetails) && !isTokenExpired(token);
    	}

//    	public void validateToken(final String token) {
//            Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token);
//        }

    	public boolean verifyToken(HttpServletRequest req, String username) throws IOException {

    		String header = req.getHeader("Authorization");
    		String token = header.substring(7);
    		String authToken = generateToken(username);

    		System.out.println(token);
    		System.out.println(authToken);
    		if (!token.equals(authToken)) {
    			return false;
    		} else {
    			return true;
    		}

    	}

		
    }

