#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.web.security;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.Key;

import org.jose4j.jws.AlgorithmIdentifiers;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.jwt.MalformedClaimException;
import org.jose4j.jwt.consumer.InvalidJwtException;
import org.jose4j.jwt.consumer.JwtConsumer;
import org.jose4j.jwt.consumer.JwtConsumerBuilder;
import org.jose4j.keys.HmacKey;
import org.jose4j.lang.JoseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class JwtService {
    private static final String ISSUER = "${package}";
    public static final String USER_CLAIM = "user";
    private KeyProvider secretKeyProvider;
    private ObjectMapper mapper;

    @Autowired
    public JwtService(KeyProvider secretKeyProvider) {
        this.secretKeyProvider = secretKeyProvider;
        this.mapper = new ObjectMapper();
    }

    /**
     * Renvoie un JWS basé sur des clés asymetriques
     * @param key
     * @param claim
     * @return JWS
     * @throws IOException
     * @throws URISyntaxException
     */
    public String signedAsymetricTokenFor(final String key, final Object claim) {
    	
    	String token = null;
        
        try {

            // JWT
            JwtClaims claims = initClaims();
            claims.setSubject("userProfile");
            claims.setClaim(USER_CLAIM, this.mapper.writeValueAsString(claim));

            // JWS
            JsonWebSignature jws = new JsonWebSignature();
            jws.setPayload(claims.toJson());
            jws.setAlgorithmHeaderValue(AlgorithmIdentifiers.RSA_USING_SHA512);
            jws.setKey(secretKeyProvider.getPrivateKey());

            token = jws.getCompactSerialization();
            
		} catch (JoseException | JsonProcessingException e) {
			e.printStackTrace();
		}
        
        return  token;

    }
    
    /**
     * Renvoie un JWS
     * @param key
     * @param claim
     * @return JWS
     * @throws JoseException 
     * @throws JsonProcessingException 
     * @throws IOException
     * @throws URISyntaxException
     */
    public String signedTokenFor(final String key, final Object claim) throws JoseException, JsonProcessingException {
    	
    	String token = null;
        
        // JWT
        JwtClaims claims = initClaims();
        claims.setSubject("userProfile");
        claims.setClaim(USER_CLAIM, this.mapper.writeValueAsString(claim));

        // JWS
        JsonWebSignature jws = new JsonWebSignature();
        jws.setPayload(claims.toJson());
        jws.setAlgorithmHeaderValue(AlgorithmIdentifiers.HMAC_SHA256);
        jws.setKey(new HmacKey(secretKeyProvider.getKey()));

        token = jws.getCompactSerialization();
            
        return  token;

    }
    
    /**
     * Verifie un token JWT signé avec une clé asymétrique
     * @param token
     * @param c type du claim
     * @return
     * @throws IOException 
     * @throws InvalidJwtException 
     * @throws MalformedClaimException 
     * @throws JsonMappingException 
     * @throws JsonParseException 
     */
    public <T> T verifyAsymetricSignedToken(final String token, Class<T> c) throws JsonParseException, JsonMappingException, MalformedClaimException, InvalidJwtException, IOException {
    	
    	return this.verifySignedToken(token, secretKeyProvider.getPublicKey(), c);
    }
    
    /**
     * Verifie un token JWT signé avec une clé asymétrique
     * @param token
     * @param key
     * @param c type du claim
     * @return
     * @throws InvalidJwtException 
     * @throws IOException 
     * @throws MalformedClaimException 
     * @throws JsonMappingException 
     * @throws JsonParseException 
     */
    public <T> T verifySignedToken(final String token, final Key key, Class<T> c) throws InvalidJwtException, JsonParseException, JsonMappingException, MalformedClaimException, IOException {
    	
    	T claim = null;

        JwtConsumer jwtConsumer = new JwtConsumerBuilder()
                .setRequireExpirationTime()
                .setRequireSubject()
                .setExpectedAudience("myApplication")
                .setExpectedIssuer(ISSUER + ".myApplication")
                .setVerificationKey(key) // verification de la signature
                .build();

        //  Validate the JWT and process it to the Claims
        JwtClaims jwtClaims = jwtConsumer.processToClaims(token);
        System.out.println("JWT validation succeeded! " + jwtClaims);
        claim = mapper.readValue(jwtClaims.getStringClaimValue(USER_CLAIM), c);
        
        return claim;
    }
    
    /**
     * initialise un token JWT
     * @return les claims
     */
    private JwtClaims initClaims() {
    	
    	JwtClaims claims = new JwtClaims();
        claims.setIssuer(ISSUER + ".myApplication");  // createur du token
        claims.setAudience("myApplication"); // client du token
        claims.setExpirationTimeMinutesInTheFuture(120); // duree vie du token
        claims.setGeneratedJwtId(); // a unique identifier for the token
        claims.setIssuedAtToNow();  // when the token was issued/created (now)
        
        return claims;
    }
}