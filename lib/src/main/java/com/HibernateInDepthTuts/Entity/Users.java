package com.HibernateInDepthTuts.Entity;

import javax.annotation.processing.Generated;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;

@Entity
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;
	
	@NotNull
	private String name;
	
	@NotNull
	private String password;
	
	@OneToOne(cascade = CascadeType.REMOVE,fetch = FetchType.LAZY,optional = false)
	@MapsId
	private Address userAddress;
	
	public Users(@NotNull String name, @NotNull String password, Address userAddress) {
		super();
		this.name = name;
		this.password = password;
		this.userAddress = userAddress;
	}

	public Users() {}

	public Users(long userId, @NotNull String name, @NotNull String password, Address userAddress) {
		this.userId = userId;
		this.name = name;
		this.password = password;
		this.userAddress = userAddress;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Address getAddress() {
		return userAddress;
	}

	public void setAddress(Address userAddress) {
		this.userAddress = userAddress;
	}

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", name=" + name + ", password=" + password + ", userAddress=" + userAddress
				+ "]";
	}
	
	
	
	
}
