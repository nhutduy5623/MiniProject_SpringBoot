package com.TSP.MiniProject_SpringBoot.service.Authentication;

import com.TSP.MiniProject_SpringBoot.repository.IAccountRepository;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import lombok.Value;
import lombok.experimental.NonFinal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;

@Service
public class JwtProvider {

    @Autowired
    IAccountRepository accountRepository;

    @NonFinal
    private final String SECRET_KEY = "LwXgTRXzTSO1T4XQRtvTo5ibzanF6QY18V+Ije+NsPkSWP5J/o3H+ng8Xs3LLTJV";

    private final long EXPIRATION_TIME = 86400000; // 24 giờ

    // Tạo token JWT
    public String generateToken(String email) {
        try {
            JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
                    .subject(email)
                    .issueTime(new Date())
                    .expirationTime(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                    .claim("role", accountRepository.findOneByEmail(email))
                    .build();

            JWSObject jwsObject = new JWSObject(
                    new JWSHeader(JWSAlgorithm.HS512),
                    new Payload(claimsSet.toJSONObject())
            );

            JWSSigner signer = new MACSigner(SECRET_KEY.getBytes());
            jwsObject.sign(signer);

            return jwsObject.serialize();
        } catch (JOSEException e) {
            throw new RuntimeException("Error generating token", e);
        }
    }

    // Xác thực token JWT
    public boolean validateToken(String token) {
        try {
            JWSObject jwsObject = JWSObject.parse(token);
            JWSVerifier verifier = new MACVerifier(SECRET_KEY);
            return jwsObject.verify(verifier) && !isTokenExpired(jwsObject);
        } catch (Exception e) {
            return false;
        }
    }

    // Lấy username từ token JWT
    public String getEmailFromToken(String token) {
        try {
            JWSObject jwsObject = JWSObject.parse(token);
            return jwsObject.getPayload().toJSONObject().get("sub").toString();
        } catch (ParseException e) {
            return null;
        }
    }

    // Kiểm tra token đã hết hạn chưa
    private boolean isTokenExpired(JWSObject jwsObject) {
        long expiration = (long) jwsObject.getPayload().toJSONObject().get("exp");
        return new Date().after(new Date(expiration * 1000));
    }
}
