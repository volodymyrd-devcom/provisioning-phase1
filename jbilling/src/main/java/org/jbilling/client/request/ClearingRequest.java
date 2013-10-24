package org.jbilling.client.request;

import java.util.Date;

import org.jbilling.client.request.base.SpRequest;
import org.jbilling.config.MethodConfig;

public class ClearingRequest extends SpRequest {

	public ClearingRequest(MethodConfig config, String transactionId, String providerId, String providerName, String msisdn, Date creationDate, String subscriptionId) {
		super(config, transactionId, providerId, providerName, msisdn, creationDate, subscriptionId);
	}

}