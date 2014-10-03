package com.voldy.beans;


public class IDCard {

	
	 private String card_id;
	 private String card_name;
	 private String card_number;
	 private String expiration_date;
	 
	 private String user_id;
	 
	 public IDCard() {
		 	this.card_id = "";
	        this.card_name = "";
	        this.card_number = "";
	        this.expiration_date = "";
 }
	public IDCard(String card_id, String card_name,String card_number,String expiration_date) {
     this.card_id = card_id;
     this.card_name = card_name;
     this.card_number = card_number;
     this.expiration_date = expiration_date;
 }
	/**
	 * @return the card_id
	 */
	public String getCard_id() {
		return card_id;
	}
	/**
	 * @return the card_name
	 */
	public String getCard_name() {
		return card_name;
	}
	/**
	 * @return the card_number
	 */
	public String getCard_number() {
		return card_number;
	}
	/**
	 * @return the expiration_date
	 */
	public String getExpiration_date() {
		return expiration_date;
	}
	/**
	 * @param card_id the card_id to set
	 */
	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}
	/**
	 * @param card_name the card_name to set
	 */
	public void setCard_name(String card_name) {
		this.card_name = card_name;
	}
	/**
	 * @param card_number the card_number to set
	 */
	public void setCard_number(String card_number) {
		this.card_number = card_number;
	}
	/**
	 * @param expiration_date the expiration_date to set
	 */
	public void setExpiration_date(String expiration_date) {
		this.expiration_date = expiration_date;
	}
	/**
	 * @return the user_id
	 */
	public String getUser_id() {
		return user_id;
	}
	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	
	
}
