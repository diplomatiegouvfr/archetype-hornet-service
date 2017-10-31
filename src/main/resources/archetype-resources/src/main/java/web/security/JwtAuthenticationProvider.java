#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.web.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import hornet.framework.web.security.jwt.JwtAuthToken;

import ${package}.web.security.exceptions.JwtAuthenticationException;
import ${package}.web.security.profile.JwtAuthenticatedProfile;
import ${package}.web.security.profile.User;

@Component
public class JwtAuthenticationProvider implements AuthenticationProvider, AuthenticationManager {
	
	private final JwtService jwtService;

    @Autowired
    public JwtAuthenticationProvider(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        try {
        	User user = jwtService.verifyAsymetricSignedToken((String) authentication.getCredentials(), User.class);
            return new JwtAuthenticatedProfile(user);
        } catch (Exception e) {
            throw new JwtAuthenticationException("Failed to verify token", e);
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return JwtAuthToken.class.equals(authentication);
    }

}
