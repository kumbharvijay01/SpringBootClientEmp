/**
 * 
 */
package com.org.bhfl.entity;

/**
 * 
 */
//@Data
public class CreateTokenRequest {
	private String builderUserId;
	private String finReference;
	private String source;

	public CreateTokenRequest(String builderUserId, String finReference, String source) {
		super();
		this.builderUserId = builderUserId;
		this.finReference = finReference;
		this.source = source;
	}

	public CreateTokenRequest() {
		super();
	}

	/**
	 * @return the builderUserId
	 */
	public String getBuilderUserId() {
		return builderUserId;
	}

	/**
	 * @param builderUserId the builderUserId to set
	 */
	public void setBuilderUserId(String builderUserId) {
		this.builderUserId = builderUserId;
	}

	/**
	 * @return the finReference
	 */
	public String getFinReference() {
		return finReference;
	}

	/**
	 * @param finReference the finReference to set
	 */
	public void setFinReference(String finReference) {
		this.finReference = finReference;
	}

	/**
	 * @return the source
	 */
	public String getSource() {
		return source;
	}

	/**
	 * @param source the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	}

}
