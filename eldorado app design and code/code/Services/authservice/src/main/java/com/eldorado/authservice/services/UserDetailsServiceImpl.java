package com.eldorado.authservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.apache.log4j.Logger;

import com.eldorado.authservice.config.LoggerConfig;
import com.eldorado.authservice.constants.AuthServiceConstants;
import com.eldorado.authservice.models.AuthUser;
import com.eldorado.authservice.models.AuthUserDetails;
import com.eldorado.authservice.repositories.UserRepository;

/*
 * Class UserDetailsServiceImpl is implements UserDetailsService and
 * overriding loadUserByUsername() method to provide custom user credentials
 * like UserNname and Password along with user role
 * 
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	Logger logger = LoggerConfig.getLog();
	/*
	 * Injecting dependency for UserRepository
	 */
	
	@Autowired
	private UserRepository userRepository;
	
	/*
	 * 
	 * Return Type:UserDetails
	 * Value : User Object
	 */

	@Override
	public UserDetails loadUserByUsername(String username)  {
		
		/*
		 * Calling method findByEmail to fetch User for corresponding username
		 */
		
		AuthUser user = userRepository.findByEmail(username);
		if(user==null) {
			logger.error(AuthServiceConstants.USER_NOT_PRESENT+username);
			throw new UsernameNotFoundException(AuthServiceConstants.USER_NOT_PRESENT);
		}
		logger.info(AuthServiceConstants.USER_IS_PRSENT+username);
		UserDetails userDetails = new AuthUserDetails(user);
		return userDetails;
	}
	
}
