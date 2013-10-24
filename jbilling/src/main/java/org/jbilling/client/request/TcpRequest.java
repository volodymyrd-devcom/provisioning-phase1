package org.jbilling.client.request;

public class TcpRequest {

	public enum TCP_ACTION {
		SET, DELETE, NONE
	}

	private TCP_ACTION action = TCP_ACTION.NONE;
	private String msisdn = "";
	private boolean prepaid = false;
	private String transactionId = "";

	public TcpRequest(TCP_ACTION action, String msisdn) {

		this.action = action;
		this.msisdn = msisdn;
	}

	public TcpRequest(TCP_ACTION action, String msisdn, boolean prepaid, String transactionId) {
		this.action = action;
		this.msisdn = msisdn;
		this.prepaid = prepaid;
		this.transactionId = transactionId;
	}

	public TCP_ACTION getAction() {
		return action;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public String isPrepaid() {
		return prepaid ? "1" : "0";
	}

	public String getTransactionId() {
		return transactionId;
	}

	@Override
	public String toString() {
		StringBuilder sp = new StringBuilder();
		if (this.getAction() == TCP_ACTION.SET) {
			sp.append("SET " + getMsisdn() + " PREPAID=" + isPrepaid() + " RESELLERID=" + getTransactionId());
		} else if (this.getAction() == TCP_ACTION.DELETE) {
			sp.append("DELETE " + getMsisdn());
		}
		return sp.toString();
	}
}
