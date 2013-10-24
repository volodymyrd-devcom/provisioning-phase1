package org.jbilling.config;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.jbilling.tools.NumberUtils;
import org.jbilling.tools.StringUtils;
import org.jbilling.tools.XMLUtils;

public class MethodConfig {

	private static Logger log = Logger.getLogger(MethodConfig.class);

	private Map<String, String> parameters;
	private String methodName;
	private String configFile;

	public MethodConfig(String configFile, String methodName) throws Exception {
		System.out.println("---------------------------------------------------------");
		this.parameters = new HashMap<String, String>();
		this.methodName = methodName;
		this.configFile = configFile;
		System.out.println("Start parsing method config");
		XMLUtils parser = new XMLUtils(configFile);
		if (parser.setRoot(true, "method", "name", methodName) != 0)
			throw new Exception("The Method not configured in MethodConfig [method:" + methodName + "]");

		/* parse methods */
		System.out.println(this.methodName);
		String[] parameterNames = parser.getStringsAttributValue("param", "name");
		if (parameterNames != null) {
			for (int i = 0; i < parameterNames.length; i++) {
				String parameterName = parameterNames[i];
				String parameterValue = parser.getStringAttributValue("param", "name", parameterName, "value");
				this.setParameter(parameterName, parameterValue);
				System.out.println("    [\"" + parameterName + "\" :\"" + parameterValue + "\"]");
			}
		}
		System.out.println("End parsing method config");
		System.out.println("---------------------------------------------------------");
		System.out.println("Initialize logging");
		/* Initialize logging */
		String logConfigFile = getLog4jFile();
		if (!new File(logConfigFile).isFile()) {
			String absolutePath = new File(configFile).getAbsolutePath();
			String filePath = absolutePath.substring(0, absolutePath.lastIndexOf(File.separator));
			logConfigFile = filePath + File.separator + logConfigFile;
		}
		if (!new File(logConfigFile).isFile())
			throw new Exception("logConfig invalid in methoConfig.xml [log4j][file:" + logConfigFile + "]");
		DOMConfigurator.configureAndWatch(logConfigFile);
		System.out.println("Initialized logging");
		System.out.println("---------------------------------------------------------");
		if (log.isDebugEnabled())
			log.debug("Initialized configuration");
	}

	public String getLog4jFile() {
		return parameters.get("log4j");
	}

	public String getUrl() {
		if (StringUtils.isNullOrEmpty(parameters.get("url")))
			return getHost() + ":" + getPort();
		return parameters.get("url");
	}

	public String getHost() {
		return parameters.get("host");
	}

	public int getPort() {
		return NumberUtils.tryParseInt(parameters.get("port"));
	}

	public int getConnectTimeout() {
		return NumberUtils.tryParseInt(parameters.get("connectTimeout"));
	}

	public int getReadTimeout() {
		return NumberUtils.tryParseInt(parameters.get("readTimeout"));
	}

	public String getProxyHost() {
		return parameters.get("proxyHost");
	}

	public int getProxyPort() {
		return NumberUtils.tryParseInt(parameters.get("proxyPort"));
	}

	public String getNetworkOperatorId() {
		return parameters.get("networkOperatorId");
	}

	public String getTemplateId() {
		return parameters.get("templateId");
	}

	public String getPostActionName() {
		return parameters.get("postActionName");
	}

	public String getOriginHost() {
		return parameters.get("originHost");
	}

	public String getOriginModule() {
		return parameters.get("originModule");
	}

	public String getOriginId() {
		return parameters.get("originId");
	}

	public String getMethodName() {
		return methodName;
	}

	public String getConfigFile() {
		return configFile;
	}

	private void setParameter(String key, String value) {
		if (this.parameters != null && key != null)
			parameters.put(key, value);
	}

}