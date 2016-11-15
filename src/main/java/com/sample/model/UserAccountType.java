package com.sample.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the UserAccountType database table.
 * 
 */
@Entity
@Table(name="UserAccountType")
@NamedQuery(name="UserAccountType.findAll", query="SELECT u FROM UserAccountType u")
public class UserAccountType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private byte id;

	@Column(length=45)
	private String accountType;

	public UserAccountType() {
	}

	public byte getId() {
		return this.id;
	}

	public void setId(byte id) {
		this.id = id;
	}

	public String getAccountType() {
		return this.accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

}