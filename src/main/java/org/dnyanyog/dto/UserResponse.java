package org.dnyanyog.dto;

public class UserResponse {
	private String responseCode;
	private String responseMessage;
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	private AddUserRequest request;
	
	private UpdateUserRequest updateRequest;

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public AddUserRequest getRequest() {
		return request;
	}

	public void setRequest(AddUserRequest request) {
		this.request = request;
	}

	public UpdateUserRequest getUpdateRequest() {
		return updateRequest;
	}

	public void setUpdateRequest(UpdateUserRequest updateRequest) {
		this.updateRequest = updateRequest;
	}

	
	
}
