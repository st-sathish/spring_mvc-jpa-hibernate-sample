package com.sample.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the User database table.
 * 
 */
@Entity
@Table(name="User")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(length=64)
	private String email;

	@Temporal(TemporalType.TIMESTAMP)
	private Date expirationDate;

	private boolean isLoggedIn;

	@Temporal(TemporalType.TIMESTAMP)
	private Date lastLoginTime;

	@Column(length=45)
	private String password;

	@Column(length=512)
	private String securityToken;

	//bi-directional many-to-one association to UserAccountType
	@ManyToOne
	@JoinColumn(name="AccountTypeId")
	private UserAccountType userAccountType;

	//bi-directional many-to-one association to UserStatus
	@ManyToOne
	@JoinColumn(name="StatusId")
	private UserStatus userStatus;

	public User() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getExpirationDate() {
		return this.expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public boolean getIsLoggedIn() {
		return this.isLoggedIn;
	}

	public void setIsLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}

	public Date getLastLoginTime() {
		return this.lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSecurityToken() {
		return this.securityToken;
	}

	public void setSecurityToken(String securityToken) {
		this.securityToken = securityToken;
	}

	public UserAccountType getUserAccountType() {
		return this.userAccountType;
	}

	public void setUserAccountType(UserAccountType userAccountType) {
		this.userAccountType = userAccountType;
	}

	public UserStatus getUserStatus() {
		return this.userStatus;
	}

	public void setUserStatus(UserStatus userStatus) {
		this.userStatus = userStatus;
	}
}