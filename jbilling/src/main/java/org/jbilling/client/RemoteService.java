package org.jbilling.client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Socket;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.log4j.Logger;
import org.jbilling.config.MethodConfig;
import org.jbilling.tools.StringUtils;

public class RemoteService {
	private MethodConfig config;

	private static Logger log = Logger.getLogger(RemoteService.class.getName());

	public RemoteService(MethodConfig config) {
		this.config = config;
	}

	@SuppressWarnings("deprecation")
	public String callPost(String request) throws Exception {
		String prefix = Thread.currentThread().getStackTrace()[2].getMethodName();
		HttpClient client = new HttpClient();
		PostMethod method = new PostMethod(config.getUrl());
		client.setConnectionTimeout(config.getConnectTimeout());
		client.setTimeout(config.getReadTimeout());
		method.setRequestHeader("Content-Type", "text/xml; charset=utf-8");
		log.info("Method: " + prefix + ", Post url: " + config.getUrl() + ", Body(" + StringUtils.removeLines(request) + ")");
		method.setRequestBody(request);
		if (!StringUtils.isNullOrEmpty(config.getProxyHost()) && config.getProxyPort() != 0)
			client.getHostConfiguration().setProxy(config.getProxyHost(), config.getProxyPort());
		try {
			client.executeMethod(method);
		} catch (HttpException ex) {
			throw ex;
		}
		String response = method.getResponseBodyAsString();
		log.info("Method: " + prefix + ", Response Code: " + method.getStatusCode() + ", Body: (" + StringUtils.removeLines(response) + ")");
		if (method.getStatusCode() == HttpStatus.SC_OK)
			return response;
		else
			throw new Exception("Error #: " + method.getStatusCode() + ", Message: " + StringUtils.removeLines(method.getResponseBodyAsString()));
	}

	@SuppressWarnings("deprecation")
	public String callGet(String request) throws Exception {
		String prefix = Thread.currentThread().getStackTrace()[2].getMethodName();
		HttpClient client = new HttpClient();
		GetMethod method = new GetMethod(config.getUrl() + StringUtils.removeLines(request));
		client.setConnectionTimeout(config.getConnectTimeout());
		client.setTimeout(config.getReadTimeout());
		method.setRequestHeader("Content-Type", "text/xml; charset=utf-8");
		log.info("Method: " + prefix + ", Get url: " + config.getUrl() + ", Parameters: " + StringUtils.removeLines(request));
		if (!StringUtils.isNullOrEmpty(config.getProxyHost()) && config.getProxyPort() != 0)
			client.getHostConfiguration().setProxy(config.getProxyHost(), config.getProxyPort());
		try {
			client.executeMethod(method);
		} catch (HttpException ex) {
			throw ex;
		}
		String response = method.getResponseBodyAsString();
		log.info("Method: " + prefix + ", Response Code: " + method.getStatusCode() + ", Body: (" + StringUtils.removeLines(response) + ")");
		if (method.getStatusCode() == HttpStatus.SC_OK)
			return response;
		else
			throw new Exception("Error #: " + method.getStatusCode() + ", Message: " + StringUtils.removeLines(method.getResponseBodyAsString()));
	}

	public String callSocket(String request) throws Exception {
		String prefix = Thread.currentThread().getStackTrace()[2].getMethodName();
		log.info("Method: " + prefix + ", Socket url: " + config.getUrl() + ", Parameters: " + StringUtils.removeLines(request));
		Socket clientSocket = new Socket();
		clientSocket.connect(new InetSocketAddress(config.getHost(), config.getPort()), config.getConnectTimeout());
		DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		outToServer.writeBytes(request + '\n');
		String response = inFromServer.readLine();
		clientSocket.close();
		log.info("Method: " + prefix + ", Body: (" + StringUtils.removeLines(response) + ")");
		return response;
	}
}
