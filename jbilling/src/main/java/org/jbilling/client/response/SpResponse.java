package org.jbilling.client.response;

import javax.xml.bind.annotation.XmlAttribute;

import org.jbilling.tools.StringUtils;
import org.jbilling.tools.XMLUtils;

public class SpResponse {

	private String operatorId = "";
	private String transactionId = "";
	private String transactionStatus = "";
	private String errorNo = "";
	private String errorMessage = "";

	public SpResponse(String response) throws Exception {
		XMLUtils util = new XMLUtils();
		util.loadXML(response);
		this.operatorId = util.getStringTagValue("No");
		this.transactionId = util.getStringTagValue("Tx");
		this.transactionStatus = util.getStringTagValue("TxStatus");
		this.errorNo = util.getStringTagValue("ErrorNo");
		this.errorMessage = util.getStringTagValue("ErrorMessage");
	}

	@XmlAttribute(name = "No")
	public String getOperatorId() {
		return operatorId;
	}

	@XmlAttribute(name = "Tx")
	public String getTransactionId() {
		return transactionId;
	}

	@XmlAttribute(name = "TxStatus")
	public String getTransactionStatus() {
		return transactionStatus;
	}

	@XmlAttribute(name = "ErrorNo")
	public String getErrorNo() {
		return errorNo;
	}

	@XmlAttribute(name = "ErrorMessage")
	public String getErrorMessage() {
		return errorMessage;
	}

	public boolean isSuccess() {
		return StringUtils.isNullOrEmpty(this.errorNo);
	}

	@Override
	public String toString() {
		if (isSuccess())
			return "SUCCESS";
		return "Error #: " + errorNo + ", Message: " + errorMessage;
	}
}
