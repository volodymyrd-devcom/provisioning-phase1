package org.jbilling.client.request.base;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.bind.annotation.XmlAttribute;

import org.jbilling.config.MethodConfig;
import org.jbilling.tools.StringUtils;

public class SpRequest {

	private String operatorId = "";
	private String txTemplate = "";
	private String transactionId = "";
	private String providerId = "";
	private String actionName = "";
	private Map<String, String> actionParameter = new HashMap<String, String>();

	public SpRequest(MethodConfig config, String transactionId, String providerId, String providerName, String msisdn, Date creationDate, String subscriptionId) {
		this.actionParameter = new HashMap<String, String>();
		this.operatorId = config.getNetworkOperatorId();
		this.txTemplate = config.getTemplateId();
		this.transactionId = transactionId;
		this.providerId = providerName;
		this.actionName = config.getPostActionName();
		// Add Default Action Parameter
		this.actionParameter.put("TransactionId", transactionId);
		this.actionParameter.put("ServiceProviderId", providerId);
		this.actionParameter.put("CreationDate", StringUtils.formatDate(creationDate));
		this.actionParameter.put("ExecutionDate", StringUtils.formatDate(new Date()));
		this.actionParameter.put("SubscriptionId", subscriptionId);
		this.actionParameter.put("PrimaryMsisdn", msisdn);		
	}

	@XmlAttribute(name = "No")
	public String getOperatorId() {
		return operatorId;
	}

	@XmlAttribute(name = "TxTemplate")
	public String getTxTemplate() {
		return txTemplate;
	}

	@XmlAttribute(name = "Tx")
	public String getTransactionId() {
		return transactionId;
	}

	@XmlAttribute(name = "Sp")
	public String getProviderId() {
		return providerId;
	}

	@XmlAttribute(name = "ActionName")
	public String getActionName() {
		return actionName;
	}

	@XmlAttribute(name = "ActionParameter")
	public Map<String, String> getActionParameter() {
		return actionParameter;
	}

	@Override
	public String toString() {
		StringBuilder sp = new StringBuilder();
		sp.append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
		sp.append("<spRequest>");
		sp.append("	<Action>");
		sp.append("		<No>" + this.getOperatorId() + "</No>");
		sp.append("		<TxTemplate>" + this.getTxTemplate() + "</TxTemplate>");
		sp.append("		<Tx>" + this.getTransactionId() + "</Tx>");
		sp.append("		<Sp>" + this.getProviderId() + "</Sp>");
		sp.append("		<ActionName>" + this.getActionName() + "</ActionName>");
		for (Entry<String, String> entry : actionParameter.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			sp.append("		<ActionParameter><Key>" + key + "</Key><Value>" + value + "</Value></ActionParameter>");
		}
		sp.append("	</Action>");
		sp.append("</spRequest>");
		return sp.toString();
	}
}
