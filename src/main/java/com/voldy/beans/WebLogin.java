package com.voldy.beans;

public class WebLogin {

	private String login_id;
	private String url;
	private String login;
	private String password;

	private String user_id;

	public WebLogin() {
		this.login_id = "";
		this.url = "";
		this.login = "";
		this.password = "";
	}

	public WebLogin(String login_id, String url, String login, String password) {
		this.login_id = login_id;
		this.url = url;
		this.login = login;
		this.password = password;
	}

	/**
	 * @return the login_id
	 */
	public String getLogin_id() {
		return login_id;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @return the user_id
	 */
	public String getUser_id() {
		return user_id;
	}

	/**
	 * @param login_id the login_id to set
	 */
	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
}
