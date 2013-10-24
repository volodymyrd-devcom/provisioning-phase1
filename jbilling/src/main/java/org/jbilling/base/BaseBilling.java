package org.jbilling.base;

import org.jbilling.client.RemoteService;
import org.jbilling.config.MethodConfig;

public abstract class BaseBilling {

	private MethodConfig methodConfig;
	private RemoteService remoteService;

	public MethodConfig getMethodConfig() {
		return methodConfig;
	}

	public BaseBilling(String configFile, String methodName) throws Exception {
		this.methodConfig = new MethodConfig(configFile, methodName);
		this.remoteService = new RemoteService(methodConfig);
	}

	public RemoteService getRemoteService() {
		return remoteService;
	}
}