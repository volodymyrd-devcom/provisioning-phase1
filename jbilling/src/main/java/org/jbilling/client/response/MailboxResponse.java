package org.jbilling.client.response;

import javax.xml.bind.annotation.XmlAttribute;

import org.jbilling.tools.XMLUtils;

public class MailboxResponse {

	private String statusCode = "";
	private String message = "";

	public MailboxResponse(String response) throws Exception {
		XMLUtils util = new XMLUtils();
		util.loadXML(response);
		this.statusCode = util.getStringTagValue("STATUS-CODE");
		this.message = util.getStringTagValue("MESSAGE");
	}

	@XmlAttribute(name = "STATUS-CODE")
	public String getStatusCode() {
		return statusCode;
	}

	@XmlAttribute(name = "MESSAGE")
	public String getMessage() {
		return message;
	}

	public boolean isSuccess() {
		return "0".equals(getStatusCode());
	}

	@Override
	public String toString() {
		if (isSuccess())
			return "SUCCESS";
		return "Error #: " + getStatusCode() + ", Message: " + getMessage();
	}
}
