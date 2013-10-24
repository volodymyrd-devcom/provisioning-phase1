package org.jbilling.client.request;

import java.util.Date;

import org.jbilling.client.request.base.SpRequest;
import org.jbilling.config.MethodConfig;

public class TariffPlanChangeRequest extends SpRequest {

	public TariffPlanChangeRequest(MethodConfig config, String transactionId, String providerId, String providerName, String msisdn, Date creationDate, String subscriptionId, String newTariffPlan) {
		super(config, transactionId, providerId, providerName, msisdn, creationDate, subscriptionId);
		// Add Additional Action Parameter
		super.getActionParameter().put("NewTariffPlan", newTariffPlan);
	}

}