package com.eldorado.authservice.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 
 * @author Mohammad Faizan AuthUserDetails class is extending the AuthUser Pojo
 *         class and implementing UserDetails for overriding implementation of
 *         isAccountNonExpired,isAccountNonLocked,isCredentialsNonExpired and
 *         isEnabled
 *
 */
public class AuthUserDetails extends AuthUser implements UserDetails {

	private static final long serialVersionUID = 1L;

	/**
	 * Argument constructor for AuthUserDetails
	 * 
	 * @param user
	 */
	public AuthUserDetails(AuthUser user) {
		super(user);
	}

	/**
	 * @author Mohammad faizan
	 * @return List<GrantedAuthority> returns the list of granted authority for each
	 *         users
	 */

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> grantedAuthority = new ArrayList<>();

		getRoles().forEach(role -> 
			grantedAuthority.add(new SimpleGrantedAuthority(role.getName()))
		);
		return grantedAuthority;
	}
	

	@Override
	public String getPassword() {
		return super.getPassword();
	}

	@Override
	public boolean isAccountNonExpired() {
		return super.isAccountNonExpired();
	}

	@Override
	public boolean isAccountNonLocked() {
		return super.isAccountNonLocked();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return super.isCredentialsNonExpired();
	}

	@Override
	public boolean isEnabled() {
		return super.isEnabled();
	}

	@Override
	public String getUsername() {
		return super.getEmail();
	}

}
