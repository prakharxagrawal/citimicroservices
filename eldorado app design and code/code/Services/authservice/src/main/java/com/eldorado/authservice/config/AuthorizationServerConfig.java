package com.eldorado.authservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import com.eldorado.authservice.constants.AuthServiceConstants;

/*
 * AuthorizationServerConfig class is extending AuthorizationServerConfigurerAdapter
 * to provide custom configuration for token generation for user authentication 
 * and authorization 
 */

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	/*
	 * Injecting dependency for AuthenticationManager which serve the purpose of
	 * user authentication
	 */

	@Autowired
	private AuthenticationManager authenticationManager;

	/*
	 * Injecting dependency for UserDetailsService which serve the purpose of
	 * providing user details for authentication
	 */

	@Autowired
	private UserDetailsService userDetailsService;

	/*
	 * Injecting dependency for PasswordEncoder for encoding client password
	 */

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Value("${privateKey}")
	private String privateKey;

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {

		endpoints.tokenStore(tokenStore()).accessTokenConverter(jwtAccessTokenConverter())
				.authenticationManager(authenticationManager).userDetailsService(userDetailsService);
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

		clients.inMemory().withClient(AuthServiceConstants.CLIENT_ID).secret(passwordEncoder.encode(AuthServiceConstants.CLIENT_PASSWORD))
				.authorizedGrantTypes("password", "refresh_token").scopes("read", "write")
				.resourceIds(AuthServiceConstants.RESOURCE_ID);

	}

	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security.tokenKeyAccess("permitAll()");
	}

	/*
	 * Bean for TokenStore
	 */

	@Bean
	public TokenStore tokenStore() {
		return new JwtTokenStore(jwtAccessTokenConverter());
	}

	/*
	 * Bean for JwtAccessTokenConverter
	 */

	@Bean
	public JwtAccessTokenConverter jwtAccessTokenConverter() {
		JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
		jwtAccessTokenConverter.setSigningKey(privateKey);
		return jwtAccessTokenConverter;
	}
}
