package com.voldy.exception;

public class ApiError extends Error{

	private String message;
	private String messageTemplate;
	private String path;

	public ApiError() {

	}

	public ApiError(String message,String messageTemplate,String path) {
		this.message = message;
		this.messageTemplate = messageTemplate;
		this.path = path;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @return the messageTemplate
	 */
	public String getMessageTemplate() {
		return messageTemplate;
	}

	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @param messageTemplate
	 *            the messageTemplate to set
	 */
	public void setMessageTemplate(String messageTemplate) {
		this.messageTemplate = messageTemplate;
	}

	/**
	 * @param path
	 *            the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}

}
