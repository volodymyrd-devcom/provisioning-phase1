package org.jbilling.client.response;


public class TcpResponse {

	private String responseMessage = "";

	public TcpResponse(String response) throws Exception {
		this.responseMessage = response;
	}

	public boolean isSuccess() {
		return (responseMessage.indexOf("SUCCESS") != -1);
	}

	@Override
	public String toString() {
		if (isSuccess())
			return "SUCCESS";
		return "Error Message: " + responseMessage;
	}
}
