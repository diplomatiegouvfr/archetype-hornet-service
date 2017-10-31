#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.web.security;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import org.jose4j.base64url.Base64;

import ${package}.web.security.exceptions.JwtAuthenticationException;

public class KeyProvider {

    private final PrivateKey privateKey;
    private final PublicKey publicKey;
    private final byte[] key;

    public KeyProvider(
                final String path) throws IOException, URISyntaxException {
        // generate with ssh-keygen
        // GENERATE PRIVATE KEY in PKCS#1 format
        //openssl genrsa -f4 -out private.pem 4096
        // EXPORT PUBLIC KEY
        //openssl rsa -in private.pem -outform PEM -pubout -out public.pem
        // EXPORT PRIVATE KEY to PKCS#8 format
        //openssl pkcs8 -topk8 -inform pem -in private.pem -outform PEM -nocrypt -out private8.pem

        privateKey = convertPrivateKey(Files.readAllBytes(Paths.get(path + "/private8.pem")));
        publicKey = convertPublicKey(Files.readAllBytes(Paths.get(path + "/public.pem")));
        key = "ThisIsTheVerySuperGreatSecretKey".getBytes("UTF-8");
    }

    public PrivateKey getPrivateKey() {
        return privateKey;
    }

    public PublicKey getPublicKey() {
        return publicKey;
    }

    public byte[] getKey() {
        return key;
    }

    /**
     * genere une cle public depuis le contenu d'un fichier PEM
     * @param pem
     * @return la cle public
     */
    private PublicKey convertPublicKey(final byte[] pem) {
        PublicKey key = null;

        final String temp = new String(pem);
        final String publicKeyPEM = temp.replace(
            "-----BEGIN PUBLIC KEY-----\n", "")
                    .replace("-----END PUBLIC KEY-----", "");

        final byte[] decoded = Base64.decode(publicKeyPEM);
        final X509EncodedKeySpec pubKeySpec = new X509EncodedKeySpec(decoded);
        KeyFactory keyFactory;
        try {
            keyFactory = KeyFactory.getInstance("RSA");
            key = keyFactory.generatePublic(pubKeySpec);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new JwtAuthenticationException("Public Key init error", e);
        }
        return key;
    }

    /**
     * genere une cle privee depuis le contenu d'un fichier PEM
     * @param pem
     * @return la cle privee
     */
    private PrivateKey convertPrivateKey(final byte[] pem) {
        PrivateKey key = null;

        try {

            final String temp = new String(pem);
            final String privKeyPEM = temp.replace(
                "-----BEGIN PRIVATE KEY-----\n", "")
                        .replace("-----END PRIVATE KEY-----", "");

            final byte[] decoded = Base64.decode(privKeyPEM);
            final PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(decoded);
            final KeyFactory kf = KeyFactory.getInstance("RSA");
            key = kf.generatePrivate(spec);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new JwtAuthenticationException("Private Key init error", e);
        }
        return key;
    }
}
