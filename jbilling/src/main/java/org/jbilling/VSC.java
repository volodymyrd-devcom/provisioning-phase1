package org.jbilling;

import org.jbilling.base.BaseBilling;
import org.jbilling.client.request.MailboxRequest;
import org.jbilling.client.request.MailboxRequest.MAILBOX_ACTION;
import org.jbilling.client.response.MailboxResponse;

public class VSC extends BaseBilling {

	public VSC(String configFile) throws Exception {
		super(configFile, VSC.class.getSimpleName());
	}

	public void addSubscriberNC(String msisdn, String ownerCLI, String brandedResellerName) throws Exception {
		MailboxRequest request = new MailboxRequest(getMethodConfig(), MAILBOX_ACTION.CREATE, msisdn, ownerCLI, brandedResellerName);
		String responseStr = getRemoteService().callPost(request.toString());
		MailboxResponse response = new MailboxResponse(responseStr);
		if (!response.isSuccess())
			throw new Exception(response.toString());
	}

	public void deleteSubscriber(String msisdn) throws Exception {
		MailboxRequest request = new MailboxRequest(getMethodConfig(), MAILBOX_ACTION.DELETE, msisdn);
		String responseStr = getRemoteService().callPost(request.toString());
		MailboxResponse response = new MailboxResponse(responseStr);
		if (!response.isSuccess())
			throw new Exception(response.toString());
	}
}