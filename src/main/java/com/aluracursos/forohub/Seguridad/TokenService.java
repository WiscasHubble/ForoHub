package com.aluracursos.forohub.Seguridad;

import com.aluracursos.forohub.Usuarios.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    private final String topSecretNoCopiar = "123456789";

    public String generarToken(Usuario usuario) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(topSecretNoCopiar);
            return JWT.create()
                    .withIssuer("forohub")
                    .withSubject(usuario.getCorreo())
                    .withClaim("id", usuario.getId())
                    .withExpiresAt(generarFechaExpiracion())
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            throw new RuntimeException();
        }

    }

    public String getSubject(String token) {
//        if (token == null) {
//            throw new RuntimeException();
//        }
//        DecodedJWT verifier = null;
//        try {
//            Algorithm algorithm = Algorithm.HMAC256("123456");
//            verifier = JWT.require(algorithm)
//                    .withIssuer("forohub")
//                    .build()
//                    .verify(token);
//            var debug = verifier.getSubject();
//            System.out.println("Sujeto: "+debug);
//        } catch (JWTVerificationException exception) {
//            System.out.println(exception.toString());
//        }
//        if (verifier.getSubject() == null) {
//            throw new RuntimeException("Verifier invalido");
//        }
//        return verifier.getSubject();

        DecodedJWT verifier = null;
        try {
            Algorithm algorithm = Algorithm.HMAC256(topSecretNoCopiar);
            verifier = JWT.require(algorithm)
                    // specify any specific claim validations
                    .withIssuer("forohub")
                    // reusable verifier instance
                    .build()
                    .verify(token);
            verifier.getSubject();

        } catch (JWTVerificationException exception) {
            System.out.println(exception);
        }
        if (verifier.getSubject() == null) {
            throw new RuntimeException("Verifier invalid");
        }

        return verifier.getSubject();
    }

    private Instant generarFechaExpiracion() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-05:00"));
    }

}
