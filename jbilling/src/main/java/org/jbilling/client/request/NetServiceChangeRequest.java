package org.jbilling.client.request;

import java.util.Date;

import org.jbilling.client.request.base.SpRequest;
import org.jbilling.config.MethodConfig;

public class NetServiceChangeRequest extends SpRequest {

	public NetServiceChangeRequest(MethodConfig config, String transactionId, String providerId, String providerName, String msisdn, Date creationDate, String subscriptionId, int productT11Count,
			String productT11) {
		super(config, transactionId, providerId, providerName, msisdn, creationDate, subscriptionId);
		// Add Additional Action Parameter
		super.getActionParameter().put("ProductT11Count", Integer.toString(productT11Count));
		super.getActionParameter().put("ProductT11", productT11);
	}

}