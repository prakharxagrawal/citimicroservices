package com.eldorado.authservice.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


/**
 * @author Mohammad Faizan 
 * AuthUser :Pojo class for AuthUser Entity
 */

@Entity
public class AuthUser implements Serializable{
	
	private static final long serialVersionUID = 1L;

	/**
	 * AuthUser Class Properties
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "password")
	private String password;

	@Column(name = "email")
	private String email;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "enabled")
	private boolean enabled;

	@Column(name = "accountNonExpired")
	private boolean accountNonExpired;

	@Column(name = "credentialsNonExpired")
	private boolean credentialsNonExpired;

	@Column(name = "accountNonLocked")
	private boolean accountNonLocked;

	/**
	 * Many to Many mapping between user and role entities
	 */

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;

	/**
	 * No argument constructor for AuthUser
	 */
	public AuthUser() {

	}

	/**
	 * Argument constructor for AuthUser
	 * 
	 * @param AuthUser
	 */
	public AuthUser(AuthUser user) {
		this.password = user.getPassword();
		this.email = user.getEmail();
		this.enabled = user.isEnabled();
		this.accountNonExpired = user.isAccountNonExpired();
		this.credentialsNonExpired = user.isCredentialsNonExpired();
		this.accountNonLocked = user.isAccountNonLocked();
		this.roles = user.getRoles();
	}

	/**
	 * @return boolean {@value User enabled or not}
	 */

	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * Function to set enabled for user
	 * @param boolean
	 * @return void
	 */

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * @return boolean {@value User accountNonExpired or not}
	 */
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	/**
	 * Function to set setAccountNonExpired for user
	 * @param boolean
	 * @return void
	 */
	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	/**
	 * @return boolean {@value User isCredentialsNonExpired or not}
	 */
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	/**
	 * Function to set setCredentialsNonExpired for user
	 * @param boolean
	 * @return void
	 */
	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	/**
	 * @return boolean {@value User isCredentialsNonExpired or not}
	 */
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	/**
	 * Function to set setAccountNonLocked for user
	 * @param boolean
	 * @return void
	 */
	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	/**
	 * @return Long {@value user id}
	 */

	public Long getId() {
		return id;
	}

	/**
	 * Function to set the user id 
	 * @param Long
	 * {@value id}
	 * @return void
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return String {@value user firstName}
	 */

	public String getFirstName() {
		return firstName;
	}

	/**
	 * Function to set the user first name 
	 * @param String
	 * {@value firstName}
	 * @return void
	 */

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return String {@value user lastName}
	 */

	public String getLastName() {
		return lastName;
	}

	/**
	 * Function to set the user last name 
	 * @param String
	 * {@value lastName}
	 * @return void
	 */

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return String {@value user email}
	 */

	public String getEmail() {
		return email;
	}

	/**
	 * Function to set the user email
	 * @param String
	 * {@value email}
	 * @return void
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return String {@value user password}
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Function to set the user password
	 * @param String
	 * {@value password}
	 * @return void
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return String {@value user email}
	 */
	public Set<Role> getRoles() {
		return roles;
	}
	
	/**
	 * Function to set the user roles
	 * @param Set<Role>
	 * {@value user roles}
	 * @return void
	 */
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}
