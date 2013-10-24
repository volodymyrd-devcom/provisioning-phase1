package org.jbilling.client.request;

import org.jbilling.config.MethodConfig;

public class MailboxRequest {
	public enum MAILBOX_ACTION {
		CREATE, DELETE, NONE
	}

	private MAILBOX_ACTION action = MAILBOX_ACTION.NONE;
	private String msisdn = "";
	private String ownerCLI = "";
	private String brandedResellerName = "";
	private MethodConfig config;

	public MailboxRequest(MethodConfig config, MAILBOX_ACTION action, String msisdn) {
		this.config = config;
		this.action = action;
		this.msisdn = msisdn;
	}

	public MailboxRequest(MethodConfig config, MAILBOX_ACTION action, String msisdn, String ownerCLI, String brandedResellerName) {
		this.config = config;
		this.action = action;
		this.msisdn = msisdn;
		this.ownerCLI = ownerCLI;
		this.brandedResellerName = brandedResellerName;
	}

	public MAILBOX_ACTION getAction() {
		return action;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public String getOwnerCLI() {
		return ownerCLI;
	}

	public String getBrandedResellerName() {
		return brandedResellerName;
	}

	@Override
	public String toString() {
		StringBuilder sp = new StringBuilder();
		if (this.getAction() == MAILBOX_ACTION.CREATE) {
			sp.append("<MAILBOX cmd=\"entry-create\">");
			sp.append("	<REQUEST-ORIGIN host=\"" + config.getOriginHost() + "\" module=\"" + config.getOriginModule() + "\" id=\"" + config.getOriginId() + "\"/>");
			sp.append("	<RECORD>");
			sp.append("		<MSISDN>" + getMsisdn() + "</MSISDN>");
			sp.append("		<OwnerCLI>" + getOwnerCLI() + "</OwnerCLI>");
			sp.append("		<BRShortName>" + getBrandedResellerName() + "</BRShortName>");
			sp.append("	</RECORD>");
			sp.append("</MAILBOX>");
		} else if (this.getAction() == MAILBOX_ACTION.DELETE) {
			sp.append("<MAILBOX cmd=\"entry-delete\">");
			sp.append("	<REQUEST-ORIGIN host=\"" + config.getOriginHost() + "\" module=\"" + config.getOriginModule() + "\" id=\"" + config.getOriginId() + "\"/>");
			sp.append("	<KEY>");
			sp.append("		<MSISDN>" + getMsisdn() + "</MSISDN>");
			sp.append("	</KEY>");
			sp.append("</MAILBOX>");
		}
		return sp.toString();
	}
}
