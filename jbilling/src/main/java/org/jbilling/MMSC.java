package org.jbilling;

import org.jbilling.base.BaseBilling;
import org.jbilling.client.request.TcpRequest;
import org.jbilling.client.request.TcpRequest.TCP_ACTION;
import org.jbilling.client.response.TcpResponse;

public class MMSC extends BaseBilling {

	public MMSC(String configFile) throws Exception {
		super(configFile, MMSC.class.getSimpleName());
	}

	public void barring() {

	}

	public void addSubscriber(String msisdn, boolean prepaid, String transactionId) throws Exception {
		TcpRequest request = new TcpRequest(TCP_ACTION.SET, msisdn, prepaid, transactionId);
		String responseStr = getRemoteService().callSocket(request.toString());
		TcpResponse response = new TcpResponse(responseStr);
		if (!response.isSuccess())
			throw new Exception(response.toString());
	}

	public void deleteSubscriber(String msisdn) throws Exception {
		TcpRequest request = new TcpRequest(TCP_ACTION.DELETE, msisdn);
		String responseStr = getRemoteService().callSocket(request.toString());
		TcpResponse response = new TcpResponse(responseStr);
		if (!response.isSuccess())
			throw new Exception(response.toString());
	}

	public void setDataRoamingLimit() {

	}
}