package org.jbilling;

import java.util.Date;

import org.jbilling.base.BaseBilling;
import org.jbilling.client.request.ActivateGPRSRequest;
import org.jbilling.client.request.ActivateRequest;
import org.jbilling.client.request.BlockingRequest;
import org.jbilling.client.request.ClearingRequest;
import org.jbilling.client.request.DeactivateRequest;
import org.jbilling.client.request.NetServiceChangeRequest;
import org.jbilling.client.request.TariffPlanChangeRequest;
import org.jbilling.client.response.SpResponse;

public class EDIGW extends BaseBilling {

	public EDIGW(String configFile) throws Exception {
		super(configFile, EDIGW.class.getSimpleName());
	}

	public String activate(String transactionId, String providerId, String providerName, String msisdn, Date creationDate, String subscriptionId, String tariffPlan) throws Exception {
		ActivateRequest request = new ActivateRequest(getMethodConfig(), transactionId, providerId, providerName, msisdn, creationDate, subscriptionId, tariffPlan);
		String responseStr = getRemoteService().callPost(request.toString());
		SpResponse response = new SpResponse(responseStr);
		if (!response.isSuccess())
			throw new Exception(response.toString());
		return response.getTransactionId();
	}

	public String activateGPRS(String transactionId, String providerId, String providerName, String msisdn, Date creationDate, String subscriptionId, String productT11) throws Exception {
		ActivateGPRSRequest request = new ActivateGPRSRequest(getMethodConfig(), transactionId, providerId, providerName, msisdn, creationDate, subscriptionId, productT11);
		String responseStr = getRemoteService().callPost(request.toString());
		SpResponse response = new SpResponse(responseStr);
		if (!response.isSuccess())
			throw new Exception(response.toString());
		return response.getTransactionId();
	}

	public String deactivate(String transactionId, String providerId, String providerName, String msisdn, Date creationDate, String subscriptionId) throws Exception {
		DeactivateRequest request = new DeactivateRequest(getMethodConfig(), transactionId, providerId, providerName, msisdn, creationDate, subscriptionId);
		String responseStr = getRemoteService().callPost(request.toString());
		SpResponse response = new SpResponse(responseStr);
		if (!response.isSuccess())
			throw new Exception(response.toString());
		return response.getTransactionId();
	}
	
	public String blocking(String transactionId, String providerId, String providerName, String msisdn, Date creationDate, String subscriptionId) throws Exception {
		BlockingRequest request = new BlockingRequest(getMethodConfig(), transactionId, providerId, providerName, msisdn, creationDate, subscriptionId);
		String responseStr = getRemoteService().callPost(request.toString());
		SpResponse response = new SpResponse(responseStr);
		if (!response.isSuccess())
			throw new Exception(response.toString());
		return response.getTransactionId();
	}

	public String clearing(String transactionId, String providerId, String providerName, String msisdn, Date creationDate, String subscriptionId) throws Exception {
		ClearingRequest request = new ClearingRequest(getMethodConfig(), transactionId, providerId, providerName, msisdn, creationDate, subscriptionId);
		String responseStr = getRemoteService().callPost(request.toString());
		SpResponse response = new SpResponse(responseStr);
		if (!response.isSuccess())
			throw new Exception(response.toString());
		return response.getTransactionId();
	}

	public String netServiceChange(String transactionId, String providerId, String providerName,
								String msisdn, Date creationDate, String subscriptionId, int productT11Count, String productT11) throws Exception {
		NetServiceChangeRequest request = new NetServiceChangeRequest(getMethodConfig(), transactionId, providerId, providerName, 
				msisdn, creationDate, subscriptionId, productT11Count, productT11);
		String responseStr = getRemoteService().callPost(request.toString());
		SpResponse response = new SpResponse(responseStr);
		if (!response.isSuccess())
			throw new Exception(response.toString());
		return response.getTransactionId();
	}

	public String tariffPlanChange(String transactionId, String providerId, String providerName, String msisdn, Date creationDate, String subscriptionId, String newTariffPlan) throws Exception {
		TariffPlanChangeRequest request = new TariffPlanChangeRequest(getMethodConfig(), transactionId, providerId, providerName, msisdn, creationDate, subscriptionId, newTariffPlan);
		String responseStr = getRemoteService().callPost(request.toString());
		SpResponse response = new SpResponse(responseStr);
		if (!response.isSuccess())
			throw new Exception(response.toString());
		return response.getTransactionId();
	}
}