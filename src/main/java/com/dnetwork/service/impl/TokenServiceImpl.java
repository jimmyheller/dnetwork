package com.dnetwork.service.impl;

import com.dnetwork.domain.DNetUser;
import com.dnetwork.domain.DNetUserToken;
import com.dnetwork.domain.DNetUserTokenReposiroty;
import com.dnetwork.domain.DNetUserRepository;
import com.dnetwork.service.api.TokenService;
import io.jsonwebtoken.*;
import io.jsonwebtoken.impl.TextCodec;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.stereotype.Service;
import java.util.Date;


@Service
@EnableMongoAuditing
@Slf4j
public class TokenServiceImpl implements TokenService {

    private final DNetUserTokenReposiroty dNetUserTokenReposiroty;
    private final DNetUserRepository repository;
    public static final long JWT_TOKEN_VALIDITY =10 * 24 * 60 * 60;
    @Value("${app.jwtSecret}")
    public String jwtSecret ;


    public TokenServiceImpl(DNetUserTokenReposiroty dNetUserTokenReposiroty, DNetUserRepository repository) {
        this.dNetUserTokenReposiroty = dNetUserTokenReposiroty;
        this.repository = repository;
    }

    @Override
    public String generateTokenForAuthenticatedUser(String userId,String physicalDeviceAddress) {
        DNetUser user = repository.findById(userId);
        String token = null;
        if (user != null) {
            DNetUserToken dNetUserTokenForGenerateToken = new DNetUserToken(userId,"",physicalDeviceAddress);
            String tokenId =  dNetUserTokenReposiroty.save(dNetUserTokenForGenerateToken).getId();
            String jws = Jwts.builder()
                    .setSubject(tokenId)
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
                    .signWith(
                            SignatureAlgorithm.HS256,
                            TextCodec.BASE64.decode(jwtSecret)
                    )
                    .compact();
            dNetUserTokenForGenerateToken.setToken(jws);
            dNetUserTokenReposiroty.save(dNetUserTokenForGenerateToken);
            token =dNetUserTokenForGenerateToken.getToken();
        }
        return token;
    }

    @Override
    public Integer validateToken(String token,String physicalDeviceAddress) {

        try {
                Claims claims =  Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
                DNetUserToken dNetUserToken = dNetUserTokenReposiroty.findById(claims.getSubject());
                if(physicalDeviceAddress.equals(dNetUserToken.getPhysicalDeviceAddress())) {
                    log.info("validateToken = true");
                    return 0;
                }else {
                    log.error("Invalid physicalDeviceAddress");
                    return 100;
                }
        } catch (SignatureException ex) {
            log.error("Invalid JWT signature");
            return 101;
        } catch (MalformedJwtException ex) {
            log.error("Invalid JWT token");
            return 102;
        } catch (ExpiredJwtException ex) {
            log.error("Expired JWT token");
            return 103;
        } catch (UnsupportedJwtException ex) {
            log.error("Unsupported JWT token");
            return 104;
        } catch (IllegalArgumentException ex) {
            log.error("JWT claims string is empty.");
            return 105;
        }
    }

}
