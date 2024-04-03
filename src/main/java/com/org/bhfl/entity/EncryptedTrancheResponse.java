/**
 * 
 */
package com.org.bhfl.entity;

/**
 * 
 */
//@Data
public class EncryptedTrancheResponse {
	private TrancheResponse trancheResponse;
	private String authorization;

	public EncryptedTrancheResponse(TrancheResponse trancheResponse, String authorization) {
		super();
		this.trancheResponse = trancheResponse;
		this.authorization = authorization;
	}

	public EncryptedTrancheResponse() {
		super();
	}

	/**
	 * @return the trancheResponse
	 */
	public TrancheResponse getTrancheResponse() {
		return trancheResponse;
	}

	/**
	 * @param trancheResponse the trancheResponse to set
	 */
	public void setTrancheResponse(TrancheResponse trancheResponse) {
		this.trancheResponse = trancheResponse;
	}

	/**
	 * @return the authorization
	 */
	public String getAuthorization() {
		return authorization;
	}

	/**
	 * @param authorization the authorization to set
	 */
	public void setAuthorization(String authorization) {
		this.authorization = authorization;
	}

}
