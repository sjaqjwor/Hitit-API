package me.hitit.api.utils.auth;

import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.io.UnsupportedEncodingException;

public class JWT {
    private static String ISSUER = "hitit";
    private static String SECRET = "tmvmfld!";

    public static String create(long uidx) {
        try {
            JWTCreator.Builder b = com.auth0.jwt.JWT.create();
            b.withIssuer(ISSUER);
            b.withClaim("uidx", uidx);
            return b.sign(Algorithm.HMAC256(SECRET));
        } catch (UnsupportedEncodingException ignored) {
        } catch (JWTCreationException ignored) {
        }
        return null;
    }

    public static Token decode(String token) {
        try {
            JWTVerifier v = com.auth0.jwt.JWT.require(Algorithm.HMAC256(SECRET)).withIssuer(ISSUER).build();
            DecodedJWT djwt = v.verify(token);
            return new Token(djwt.getClaim("uidx").asLong().longValue());
        } catch (UnsupportedEncodingException ignored) {
        } catch (JWTVerificationException ignored) {
        } catch (Exception ignored) {
        }
        return null;
    }

    public static class Token {
        private long uidx;

        public Token(long uidx) {
            this.uidx = uidx;
        }

        public long getUidx() {
            return uidx;
        }
    }
}
