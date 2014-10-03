package com.voldy.beans;

import org.hibernate.validator.constraints.NotBlank;
public class User {
	private String id;
	@NotBlank(message = "Email cannot be blank!")
	private String email;
	@NotBlank(message = "Password cannot be blank!")
	private String password;
	private String created_at;
	private String updated_at;
	
	public User() {
    }
	public User(String id, String email,String password,String created_at,String updated_at) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.created_at = created_at;
        this.updated_at  = updated_at;
    }
	
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @return the created_at
	 */
	public String getCreated_at() {
		return created_at;
	}
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @param created_at the created_at to set
	 */
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	/**
	 * @return the updated_at
	 */
	public String getUpdated_at() {
		return updated_at;
	}
	/**
	 * @param updated_at the updated_at to set
	 */
	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}
	
	
	
}
